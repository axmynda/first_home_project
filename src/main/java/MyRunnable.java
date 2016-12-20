
public class MyRunnable implements Runnable{

        private String path;
        private Shared shared;
        MyReader reader;

    public MyRunnable(String path, Shared shared) {
            this.path = path;
            this.shared = shared;

        }

    public void run(){
        reader = new MyReader(path);
        String[] words;
        while((words = reader.readerWords()) != null ){
            synchronized (shared) {
                if(shared.end) {
                    return;
                }

                for (String word : words) {
                    if (shared.set.contains(word)){
                        System.out.printf("Повтор: " + word);
                        shared.end = true;
                    } else {
                        shared.set.add(word);
                    }
                }
            }
        }
    }


}


