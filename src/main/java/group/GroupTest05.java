package group;

public class GroupTest05 {
    //递归执行
    public static void main(String[] args) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup group1 = new ThreadGroup(group, "A");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("method!");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadGroup group2 = new ThreadGroup(group1, "B");
        ThreadGroup[] listGroup1 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(listGroup1,true);
        for(int i = 0 ; i < listGroup1.length; i++){
            if(listGroup1[i] != null){
                System.out.println(listGroup1[i].getName());
            }
        }

        //非递归执行
        ThreadGroup[] listGroup2 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(listGroup2,false);
        for(int i = 0 ; i< listGroup2.length; i++){
            if(listGroup2[i] != null){
                System.out.println(listGroup2[i].getName());
            }
        }
    }
}
