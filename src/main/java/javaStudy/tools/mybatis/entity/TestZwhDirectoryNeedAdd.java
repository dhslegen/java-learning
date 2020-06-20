package javaStudy.tools.mybatis.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestZwhDirectoryNeedAdd implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String cname;

    private String medicineName;

    private Float paymentProportion;

    private String paymentAreaCode;

    private String form;

    private String healthCareCategory;

    private String directoryType;


}
