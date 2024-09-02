package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    /*
    Given an absolute path for a Unix-style file system, which begins with a slash '/',
    transform this path into its simplified canonical path.

    In Unix-style file system context, a single period '.' signifies the current directory,
    a double period ".." denotes moving up one directory level, and multiple slashes such as "//"
    are interpreted as a single slash. In this problem, treat sequences of periods not covered by
    the previous rules (like "...") as valid names for files or directories.

    The simplified canonical path should adhere to the following rules:

    It must start with a single slash '/'.
    Directories within the path should be separated by only one slash '/'.
    It should not end with a slash '/', unless it's the root directory.
    It should exclude any single or double periods used to denote current or parent directories.

    Return the new path.
     */

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
