package dsa.dividenconquer.java.dsa.stack;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path){
        String[] indPath = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String oneFolder: indPath){
            if (oneFolder.isEmpty() || oneFolder.equals(".")){

            }
            else if(oneFolder.equals("..")){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else{
                stack.push(oneFolder);
            }
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }
}
