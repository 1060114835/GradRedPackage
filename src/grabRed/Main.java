package grabRed;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RedPackage redPackage = new RedPackage(100);
        GrabUtil.startGrab(5,redPackage);
    }
}
