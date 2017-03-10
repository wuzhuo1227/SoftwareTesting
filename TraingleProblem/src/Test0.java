/**
 * Created by wuzhuo on 17/3/5.
 */
public class Test0 {

    //a,b,c 三角形的三边
    public boolean isTriangle(int a, int b, int c) {
        if (a+b>c && a+c>b && b+c>a) {
            return true;
        } else {
            return false;
        }
    }

    //是否等边
    public boolean isEquilateral(int a, int b, int c) {
        if (a==b && a==c && b==c) {
            return true;
        } else {
            return false;
        }
    }

    //是否等腰
    public boolean isIsosceles(int a, int b, int c) {
       if (isTriangle(a,b,c)) {
           if (a==b || a==c || b==c) {
               return true;
           } else {
               return false;
           }
       } else {
           return false;
       }
    }

    //三边都不想等
    public boolean isScalene(int a, int b, int c) {
       if (isTriangle(a,b,c)) {
           if (a!=b && a!=c && b!=c) {
               return true;
           } else {
               return false;
           }
       } else {
           return false;
       }
    }
}
