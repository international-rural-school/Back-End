package com.lambdaschool.ruralSchools.models;

import java.util.concurrent.atomic.AtomicLong;

public class School
{
    private static final AtomicLong counter = new AtomicLong();
    private long schoolid;
    private String schoolname;

    public School(String schoolname)
    {
        this.schoolid = counter.incrementAndGet();
        this.schoolname = schoolname;
    }

    public static AtomicLong getCounter()
    {
        return counter;
    }

    public long getSchoolid()
    {
        return schoolid;
    }

    public void setSchoolid(long schoolid)
    {
        this.schoolid = schoolid;
    }

    public String getSchoolname()
    {
        return schoolname;
    }

    public void setSchoolname(String schoolname)
    {
        this.schoolname = schoolname;
    }
}
