package info.sandroalmeida;

public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int r1 = 0, r2 = 0;
        int length = Math.max(v1.length, v2.length);

        for(int i = 0; i < length; i++){
            r1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            r2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if(r1 != r2) return r1 > r2 ? 1 : -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.01.001";
        String v2 = "1.1.1";
        System.out.println(compareVersion(v1, v2));
    }
}
