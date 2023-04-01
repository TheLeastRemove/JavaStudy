package Solutions;

import java.util.ArrayList;
import java.util.Date;

public class MemoManager {
    private ArrayList<Memo> memos;

    public MemoManager() {
        memos = new ArrayList<>();
    }

    public void addMemo(Date createdDate, Date deadline, String content, int priority, boolean remind, Date remindTime) {
        memos.add(new Memo(createdDate, deadline, content, priority, remind, remindTime));
    }

    public void addMemo(Date createdDate, Date deadline, String content, int priority, boolean remind, int remindDelay) {
        Date remindTime = new Date(createdDate.getTime() + remindDelay);
        memos.add(new Memo(createdDate, deadline, content, priority, remind, remindTime));
    }

    public void editMemo(int memoIndex, Date createdDate, Date deadline, String content, int priority, boolean remind, Date remindTime) {
        memos.set(memoIndex, new Memo(createdDate, deadline, content, priority, remind, remindTime));
    }

    public void deleteMemo(int memoIndex) {
        memos.remove(memoIndex);
    }

    public ArrayList<Memo> searchMemoByKeyword(String keyword) {
        ArrayList<Memo> searchResult = new ArrayList<>();
        for (Memo memo : memos) {
            if (memo.getContent().contains(keyword)) {
                searchResult.add(memo);
            }
        }
        return searchResult;
    }

    public void checkReminders() {
        for (Memo memo : memos) {
            if (memo.isRemind() && new Date().after(memo.getRemindTime())) {
                System.out.println("Reminder: " + memo.getContent());
            }
        }
    }

    public void printAllMemos() {
        for (Memo memo : memos) {
            System.out.println(memo);
        }
    }


}

