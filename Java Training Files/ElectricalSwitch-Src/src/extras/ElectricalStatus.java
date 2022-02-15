package extras;

/**
 * 電気の状態を表すステータス用enum.
 *
 * @author tito
 * @version 2019/09/25
 */
public enum ElectricalStatus {

    /** 初期状態.*/
    INIT
    /** OFF. */
    , OFF
    /** ON.*/
    , ON
    /** 故障中. */
    , MALFUNCTION
    /** 電球がソケットにささっていない. */
    , NOT_EXISTS_LIGHT_BULB
    ;

}
