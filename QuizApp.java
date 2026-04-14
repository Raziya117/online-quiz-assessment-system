import java.util.*;

class Question{
    String question;
    String options[];
    char correctAns;
    Question(String question,String options[],char correctAns){
        this.question=question;
        this.options=options;
        this.correctAns=correctAns;
    }
    
}
public class QuizApp{
    public static void main(String args[]){
        System.out.println("Welcome to Online Quiz System");
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Admin"+ "\n" + "2.User");
        System.out.println("Enter your choice");
        int ch=sc.nextInt();
        sc.nextLine();
        if(ch==1){
            addQuestion(sc);
        }
        else{
            startQuiz(sc);
        }
    }

    public static void addQuestion(Scanner sc){
        try {
            java.io.FileWriter fw=new java.io.FileWriter("questions.txt",true);
             System.out.println("Enter question:");
              String question=sc.nextLine();
             String options[]=new String[4];
             for(int i=0;i<4;i++){
                System.out.println("Enter option"+(char)('A'+i)+":");
                options[i]=sc.nextLine();
             }
             System.out.println("Enter correct answer(A/B/C/D):");
             char correctAns=sc.next().toUpperCase().charAt(0);
             fw.write(question+"\n");
             for(String op:options){
                fw.write(op+"\n");
             }
             fw.write(correctAns+"\n");
             fw.close();
             System.out.println("Question added successfully!");
            
        } catch (Exception e) {
            System.out.println("Error adding question:"+e);
        }
       
    }
    public static void startQuiz(Scanner sc){
        ArrayList<Question>questions=new ArrayList<>();
        try{
            java.io.BufferedReader br=new java.io.BufferedReader(new java.io.FileReader("questions.txt"));
            String line;
            while((line=br.readLine())!=null){
                String question=line;
                String options[]=new String[4];
                for(int i=0;i<4;i++){
                    options[i]=br.readLine();
                }
                String ansLine=br.readLine();
                if(ansLine==null)break;
                char correctAns=ansLine.charAt(0);
                questions.add(new Question(question,options,correctAns));
            }
            br.close();
        }
        catch(Exception e){
            System.out.println("Error reading file:"+e);
        }
    
        int score=0;
        int qno=1;
        
        System.out.println("You have 10 seconds to answer each question...");
        for(Question q:questions){
            System.out.println("Question "+qno+":"+q.question);
            
            for(String op:q.options){
                System.out.println(op);
            }
            
            System.out.println("Enter your answer(A/B/C/D): ");
            final String ans[]={null};
            Thread t=new Thread(()->{
                try{
                    ans[0]=sc.nextLine();
                }
                catch(Exception e){}
            });
            t.setDaemon(true);
            t.start();
            try {
                for(int i=10;i>0;i--){
                    System.out.print("\rTime left:"+i+"sec");
                    Thread.sleep(1000);
                    if (ans[0]!=null){break;}
                }
            } catch (Exception e) {}
            if(ans[0]==null||ans[0].isEmpty()){
                System.out.println("Times up! Moving to next question....");
            }
            else{
                char ansChar=ans[0].toUpperCase().charAt(0);
                if(ansChar==q.correctAns){
                    System.out.println("Correct!");
                    score++;
                }
                else{
                    System.out.println("Wrong answer! Correct answer is: "+q.correctAns);
                }
            }
            qno++;
             try {
                 Thread.sleep(300);
             }catch (Exception e) {}
        }
        System.out.println("\n===========================");
        System.out.println("\nQuiz Finished!");
        System.out.println("Your Score:"+score+"/"+questions.size());
        double percent=(score*100.0)/questions.size();

        if(percent>=80){
            System.out.println("Excellent!You got all answers correct!");
        }
        else if(percent>=50){
            System.out.println("Good job! You did well.");
        }
        else{
            System.out.println("Better luck next time!Keep practicing.");
        }
    }
}