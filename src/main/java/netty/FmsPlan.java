package netty;

import lombok.Data;

/**
 * @author xuan
 * @date 2018-05-04 00:36.
 */
@Data
public class FmsPlan {
    private Integer legType;
    private Float legLength;
    private Character overfly;

    private String originWptIdent;
    private Float originWptPositionLat;
    private Float originWptPositionLon;

    private String termWptIdent;
    private Float termWptPositionLat;
    private Float termWptPositionLon;

    private Float refWaypointPositionLat;
    private Float refWaypointPositionLon;
    private Float refDistance;
    private Integer turnDirection;

    /*************** （2）限制信息********************4*/

    private Float lowerAltRestriction;
    private Float upperAltRestriction;
    private Float speedRestrictionSpeed;
    private Float rta;

    /****************（3）动态数据********************7*/

    private Float predictedAltitude;
    private Float predictedSpeed;
    private Float eta;
    private Float temperatureInfo;
    private Float windMagnitude;
    private Float windDirection;
    private Float fuelRemaining;

}
