package netty;

import lombok.Data;

/**
 * @author xuan
 * @date 2018-05-04 00:37.
 */
@Data
public class FmsRoute {
    private Integer index;
    private Float dist;
    private Float altitude;
    private Float vpa;
    private Float inputAltitudeLimit;
    private Integer mode;
    private Integer limitType;
    private Integer approachLegTypes;
}
