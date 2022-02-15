package extras;

import java.security.SecureRandom;

public class MalfunctionImpl implements Malfunction {

    public boolean isMalfunction() {
        int r = new SecureRandom().nextInt(10);
        if (r % 2 == 0) {
            return false;
        }
        return true;
    }

}
