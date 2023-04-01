package Solutions;

import java.util.Date;

public class Memo {
    private Date createdDate;
    private Date deadline;
    private String content;
    private int priority;
    private boolean remind;
    private Date remindTime;
    private int remindDelay; // in minutes

    public Memo(Date createdDate, Date deadline, String content, int priority, boolean remind, Date remindTime) {
        this.createdDate = createdDate;
        this.deadline = deadline;
        this.content = content;
        this.priority = priority;
        this.remind = remind;
        this.remindTime = remindTime;
        this.remindDelay = 0;
    }

    public Memo(Date createdDate, Date deadline, String content, int priority, boolean remind, int remindDelay) {
        this.createdDate = createdDate;
        this.deadline = deadline;
        this.content = content;
        this.priority = priority;
        this.remind = remind;
        this.remindTime = null;
        this.remindDelay = remindDelay;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isRemind() {
        return remind;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    public int getRemindDelay() {
        return remindDelay;
    }

    public void setRemindDelay(int remindDelay) {
        this.remindDelay = remindDelay;
    }

    public boolean isRemindTriggered() {
        if (!remind || (remindTime == null && remindDelay == 0)) {
            return false;
        }
        Date now = new Date();
        if (remindTime != null) {
            return now.after(remindTime);
        } else {
            Date remindTime = new Date(createdDate.getTime() + remindDelay * 60 * 1000);
            return now.after(remindTime);
        }
    }

    public void triggerRemind() {
        if (isRemindTriggered()) {
            System.out.println("Reminder: " + content);
        }
    }
}


