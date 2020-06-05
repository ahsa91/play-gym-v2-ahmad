package models;

import play.db.jpa.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Assessment extends Model
{
    public String strDate;
    public float weight;
    public float chest;
    public float thigh;
    public float upperArm;
    public float waist;
    public float hips;
    public String comment;

    public Assessment(String strDate,float weight, float chest, float thigh,float upperArm, float waist,float hips,String comment )
    {
        this.strDate=strDate;
        this.weight = weight;
        this.chest=chest;
        this.thigh=thigh;
        this.upperArm=upperArm;
        this.waist=waist;
        this.hips=hips;
        this.comment=comment;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        this.strDate = dateFormat.format(date);
    }
}