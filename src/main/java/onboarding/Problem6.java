package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return new ArrayList<>();
    }


    // 이메일 형식체크
    public static boolean isValidEmail(String email) {
        if (email.isEmpty()) return false;  //null값인 경우(빈값)

        //방법 :정규식
        String regex = "^[a-z_0-9]{1,9}(@email.com)$";  //전체 길이 제한, 도메인 형식에 맞게
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) return true;
        return false;
    }

    // 닉네임 형식체크 :정규식
    public static boolean isValidNickname(String nickname) {
        if (nickname.isEmpty()) return false;  //null값인 경우(빈값)

        String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nickname);
        if (m.matches()) return true;
        return false;
    }

    //통과한 것만  hashmap<닉네임, 이메일>에 저장
    public static void makeValidForms(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            if (!isValidEmail(forms.get(i).get(0)) || !isValidNickname(forms.get(i).get(1))) {
                forms.remove(i);
            }
        }
    }



}