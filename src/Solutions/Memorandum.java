package Solutions;

import java.util.Date;

/**
 * @author QM
 * @version 1.0
 * @date 2023/3/31
 * @description Memorandum
 * @className Memorandum
 * @package Solutions
 */
public class Memorandum {
    private Date date;
    private String content;
    private int importanceLevel;
    private boolean remind;
    private Date deadline;
    private String reminderTimeOrCycle;
    private boolean reminderDismissed;
    private Date reminderSnoozeTime;
    private int reminderSnoozeDuration;

    public Memorandum() {
        this.date = new Date();
        this.content = "";
        this.importanceLevel = 0;
        this.remind = false;
        this.deadline = null;
        this.reminderTimeOrCycle = "";
        this.reminderDismissed = false;
        this.reminderSnoozeTime = null;
        this.reminderSnoozeDuration = 0;
    }

    public Memorandum(String content) {
        this.date = new Date();
        this.content = content;
        this.importanceLevel = 0;
        this.remind = false;
        this.deadline = null;
        this.reminderTimeOrCycle = "";
        this.reminderDismissed = false;
        this.reminderSnoozeTime = null;
        this.reminderSnoozeDuration = 0;
    }

    public Memorandum(String content, int importanceLevel, boolean remind, Date deadline, String reminderTimeOrCycle) {
        this.date = new Date();
        this.content = content;
        this.importanceLevel = importanceLevel;
        this.remind = remind;
        this.deadline = deadline;
        this.reminderTimeOrCycle = reminderTimeOrCycle;
        this.reminderDismissed = false;
        this.reminderSnoozeTime = null;
        this.reminderSnoozeDuration = 0;
    }

    public Date getDate() {
        return date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setImportanceLevel(int importanceLevel) {
        this.importanceLevel = importanceLevel;
    }

    public int getImportanceLevel() {
        return importanceLevel;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }

    public boolean getRemind() {
        return remind;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setReminderTimeOrCycle(String reminderTimeOrCycle) {
        this.reminderTimeOrCycle = reminderTimeOrCycle;
    }

    public String getReminderTimeOrCycle() {
        return reminderTimeOrCycle;
    }

    public void remind() {
        if (remind && reminderTimeOrCycle != null && !reminderTimeOrCycle.equals("") &&
                !reminderDismissed && (reminderSnoozeTime == null || new Date().after(reminderSnoozeTime))) {
            // check if reminder time/cycle has been reached and display reminder
            System.out.println("Reminder: " + content);
        }
    }

    public void dismissReminder() {
        reminderDismissed = true;
    }

    public void snoozeReminder(int durationInMinutes) {
        reminderSnoozeTime = new Date(new Date().getTime() + durationInMinutes * 60 * 1000);
        reminderSnoozeDuration = durationInMinutes;
    }

    public boolean isReminderDismissed() {
        return reminderDismissed;
    }

    public Date getReminderSnoozeTime() {
        return reminderSnoozeTime;
    }

    public int getReminderSnoozeDuration() {
        return reminderSnoozeDuration;
    }

    public String toString() {
        return "Date: " + date + ", Content: " + content + ", Importance Level: " + importanceLevel + ", Remind: " + remind + ", Deadline: " + deadline + ", Reminder Time or Cycle: " + reminderTimeOrCycle;
    }

    public boolean equals(Object o) {
        if (o instanceof Memorandum) {
            Memorandum m = (Memorandum) o;
            return date.equals(m.getDate()) && content.equals(m.getContent()) && importanceLevel == m.getImportanceLevel() && remind == m.getRemind() && deadline.equals(m.getDeadline()) && reminderTimeOrCycle.equals(m.getReminderTimeOrCycle());
        }
        return false;
    }

    public int hashCode() {
        return date.hashCode() + content.hashCode() + importanceLevel + (remind ? 1 : 0) + deadline.hashCode() + reminderTimeOrCycle.hashCode();
    }

    public void setReminderSnoozeTime(Date reminderSnoozeTime) {
        this.reminderSnoozeTime = reminderSnoozeTime;
    }

    /**
     * @deprecated : This is a monitor program! please use the MemoTester!
     */
    public static void main(String[] args) {
        var m1 = new Memorandum("This is a memo.");
        var m2 = new Memorandum("This is a memo.");
        var m3 = new Memorandum("This is a memo.", 1, true, new Date(), "Every day");
        var m4 = new Memorandum("This is a memo.", 1, true, new Date(), "Every day");
        var m5 = new Memorandum("This is a memo.", 1, true, new Date(), "Every day");
        var m6 = new Memorandum("This is a memo.", 1, true, new Date(), "Every day");

        System.out.println(m1.equals(m2));
        System.out.println(m3.equals(m4));
        System.out.println(m5.equals(m6));

        m1.dismissReminder();
        m3.dismissReminder();
        m5.dismissReminder();

        System.out.println(m1.isReminderDismissed());
        System.out.println(m3.isReminderDismissed());
        System.out.println(m5.isReminderDismissed());

        m1.snoozeReminder(10);
        m3.snoozeReminder(10);
        m5.snoozeReminder(10);

        System.out.println(m1.getReminderSnoozeTime());
        System.out.println(m3.getReminderSnoozeTime());
        System.out.println(m5.getReminderSnoozeTime());

        System.out.println(m1.getReminderSnoozeDuration());
        System.out.println(m3.getReminderSnoozeDuration());
        System.out.println(m5.getReminderSnoozeDuration());

        System.out.println(m1);
        System.out.println(m3);
        System.out.println(m5);

        System.out.println(m1.hashCode());
        System.out.println(m3.hashCode());
        System.out.println(m5.hashCode());

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        m1.remind();
        m3.remind();
        m5.remind();

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        m1.setDeadline(new Date());
        m3.setDeadline(new Date());
        m5.setDeadline(new Date());

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        m1.setImportanceLevel(1);
        m3.setImportanceLevel(1);
        m5.setImportanceLevel(1);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        m1.setReminderTimeOrCycle("Every day");
        m3.setReminderTimeOrCycle("Every day");
        m5.setReminderTimeOrCycle("Every day");

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        m1.setRemind(true);
        m3.setRemind(true);
        m5.setRemind(true);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        m1.setContent("This is a memo.");
        m3.setContent("This is a memo.");
        m5.setContent("This is a memo.");

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

    }



}

class MemoTester {
    public static void main(String[] args) {

        var memo1 = new Memorandum();
        var memo2 = new Memorandum("Buy groceries");
        var memo3 = new Memorandum("Finish report", 2, true, new Date(new Date().getTime() + 24 * 60 * 60 * 1000), "1 hour");


        System.out.println("Memo 2 content before: " + memo2.getContent());
        memo2.setContent("Do laundry");
        System.out.println("Memo 2 content after: " + memo2.getContent());


        memo3.setRemind(true);
        memo3.remind();
        memo3.dismissReminder();
        memo3.remind();


        memo3.setRemind(true);
        memo3.setReminderSnoozeTime(new Date(new Date().getTime() + 10 * 60 * 1000));
        memo3.remind();
        memo3.snoozeReminder(5);
        memo3.remind();


        System.out.println("Memo 3 reminder snooze time: " + memo3.getReminderSnoozeTime());
    }
}


