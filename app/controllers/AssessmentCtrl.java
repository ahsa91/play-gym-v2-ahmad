package controllers;

import java.util.List;

import models.Member;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;

public class AssessmentCtrl extends Controller {
    public static void index(Long id)
    {
        Member member= Member.findById(id);
        Logger.info("Member id="+ id);
        render("member.html",member);
    }

    public static void deleteassessment(Long id, Long assessid){
        Member member= Member.findById(id);
        Assessment assess=Assessment.findById(assessid);
        Logger.info("Removing"+assess.strDate+assess.weight+
                assess.chest+assess.thigh+assess.waist+
                assess.upperArm+assess.hips+assess.comment);
        member.assessments.remove(assess);
        member.save();
        assess.delete();
        render("member.html",member);

    }

    public static void addassessment(Long id,String strDate,float weight,float chest,float thigh,float upperArm,float waist,float hips,String comment){

        Assessment assess=new Assessment(strDate,weight, chest, thigh, upperArm, waist, hips,comment);
        Member member=Member.findById(id);
        member.assessments.add(assess);
        member.save();
        redirect("/members/"+id);
    }
}
