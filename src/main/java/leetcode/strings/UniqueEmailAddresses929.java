package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuan
 * @date 2019-02-27 21:57.
 */

public class UniqueEmailAddresses929 {
    public static void main(String[] args){

    }

    public int numUniqueEmails(String[] emails) {
        String local;
        String domain;
        Set<String> posters =new HashSet<String>();
        for(String email:emails){
            int part= email.indexOf('@');
            local = email.substring(0,part);
            if (local.contains("+")){
                local=local.substring(0,local.indexOf('+'));
            }
            local=local.replace(".","");
            domain = email.substring(part);
            posters.add(local+domain);
        }
        return posters.size();
    }
}
