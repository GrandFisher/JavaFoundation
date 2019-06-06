package netty;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xuan
 * @date 2018-05-04 00:35.
 */
@Data
public class Pack implements Serializable {
    private List<FmsPlan> fmsPlans;
    private Short numLegs;
    private List<FmsRoute> fmsRoutes;
}
