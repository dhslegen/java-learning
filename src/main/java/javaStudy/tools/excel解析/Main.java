package javaStudy.tools.excel解析;

import javaStudy.tools.mybatis.entity.HealthCareMedicineDirectoryOfficial;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author dhslegen
 */

public class Main {

    public static void main(String[] args) throws IOException {
        parse("/Users/zhaowenhao/Documents/GitRepositories/document/普元公司/知识库/山东官方医保目录/副本西药部分.xlsx", new HashMap<String, String>());
    }

    public static List<HealthCareMedicineDirectoryOfficial> parse(String path, Map<String, String> forms) throws IOException {
        try (InputStream inputStream = new FileInputStream(path)) {
            Workbook wb = WorkbookFactory.create(inputStream);
            List<HealthCareMedicineDirectoryOfficial> healthCareMedicineDirectoryOfficials = new ArrayList<>();
            int count = 0;
            for (Sheet sheet : wb) {
                String[] medicineCategoryLevels = new String[4];
                for (Row row : sheet) {
                    String medicineCategoryLevelString = row.getCell(1).toString();
                    String medicineName = row.getCell(8).toString();
                    if ("".equals(medicineCategoryLevelString) && !"".equals(medicineName)) {
                        // 药品记录
                        String healthCareCategory = row.getCell(6).toString();
                        if ("甲".equals(healthCareCategory)) {
                            healthCareCategory = "01";
                        }
                        if ("乙".equals(healthCareCategory)) {
                            healthCareCategory = "02";
                        }
                        String medicineCode = row.getCell(7).toString().replace(".0", "");
                        String form = row.getCell(9).toString();
                        String comment = row.getCell(10).toString();
                        String medicineCategoryLevel1 = medicineCategoryLevels[0];
                        String medicineCategoryLevel2 = medicineCategoryLevels[1];
                        String medicineCategoryLevel3 = medicineCategoryLevels[2];
                        String medicineCategoryLevel4 = medicineCategoryLevels[3];
                        String[] split = form.split("\n");
                        String[] split1 = medicineName.split("\n");
                        List<String> split2 = new ArrayList<>();
                        if (medicineName.contains("\n")) {
                            split2.add(medicineName.replaceAll("\n", "、"));
                        }
                        split2.addAll(Arrays.asList(split1));
                        for (String s : split) {
                            for (String s1 : split2) {
                                s1 = s1.replace("（", "(").replace("）", ")");
                                HealthCareMedicineDirectoryOfficial healthCareMedicineDirectoryOfficial = new HealthCareMedicineDirectoryOfficial();
                                healthCareMedicineDirectoryOfficial.setMedicineCode(medicineCode);
                                healthCareMedicineDirectoryOfficial.setMedicineCategoryLevel1(medicineCategoryLevel1);
                                healthCareMedicineDirectoryOfficial.setMedicineCategoryLevel2(medicineCategoryLevel2);
                                healthCareMedicineDirectoryOfficial.setMedicineCategoryLevel3(medicineCategoryLevel3);
                                healthCareMedicineDirectoryOfficial.setMedicineCategoryLevel4(medicineCategoryLevel4);
                                healthCareMedicineDirectoryOfficial.setMedicineName(s1);
                                healthCareMedicineDirectoryOfficial.setForm(forms.get(s));
                                healthCareMedicineDirectoryOfficial.setHealthCareCategory(healthCareCategory);
                                healthCareMedicineDirectoryOfficial.setDirectoryType("01");
                                healthCareMedicineDirectoryOfficial.setComment(comment);
                                healthCareMedicineDirectoryOfficials.add(healthCareMedicineDirectoryOfficial);
                            }
                        }

                    } else if (!"".equals(medicineCategoryLevelString)) {
                        // 药品分类记录
                        if (!"".equals(row.getCell(2).toString())) {
                            setMedicineCategoryLevels(medicineCategoryLevels, 0, medicineCategoryLevelString);
                        }
                        if (!"".equals(row.getCell(3).toString())) {
                            setMedicineCategoryLevels(medicineCategoryLevels, 1, medicineCategoryLevelString);
                        }
                        if (!"".equals(row.getCell(4).toString())) {
                            setMedicineCategoryLevels(medicineCategoryLevels, 2, medicineCategoryLevelString);
                        }
                        if (!"".equals(row.getCell(5).toString())) {
                            setMedicineCategoryLevels(medicineCategoryLevels, 3, medicineCategoryLevelString);
                        }
                    }
                    count++;
                    System.out.println(count);
                }
            }
            return healthCareMedicineDirectoryOfficials;
        }
    }

    public static List<HealthCareMedicineDirectoryOfficial> parse1(String path) throws IOException {
        try (InputStream inputStream = new FileInputStream(path)) {
            Workbook wb = WorkbookFactory.create(inputStream);
            List<HealthCareMedicineDirectoryOfficial> healthCareMedicineDirectoryOfficials = new ArrayList<>();
            int count = 0;
            for (Sheet sheet : wb) {
                String[] medicineCategoryLevels = new String[4];
                for (Row row : sheet) {
                    String medicineCategoryLevelString = row.getCell(0).toString();
                    String medicineName = row.getCell(7).toString();
                    medicineName = medicineName.replace("（", "(").replace("）", ")");
                    if ("".equals(medicineCategoryLevelString) && !"".equals(medicineName)) {
                        // 药品记录
                        String healthCareCategory = row.getCell(5).toString();
                        if ("甲".equals(healthCareCategory)) {
                            healthCareCategory = "01";
                        }
                        if ("乙".equals(healthCareCategory)) {
                            healthCareCategory = "02";
                        }
                        String medicineCode = row.getCell(6).toString().replace(".0", "");
                        String form = "";
                        String comment = row.getCell(8).toString();
                        String medicineCategoryLevel1 = medicineCategoryLevels[0];
                        String medicineCategoryLevel2 = medicineCategoryLevels[1];
                        String medicineCategoryLevel3 = medicineCategoryLevels[2];
                        String medicineCategoryLevel4 = medicineCategoryLevels[3];
                        String[] split1 = medicineName.split("\n");
                        List<String> split2 = new ArrayList<>();
                        if (medicineName.contains("\n")) {
                            split2.add(medicineName.replaceAll("\n", "、"));
                        }
                        split2.addAll(Arrays.asList(split1));
                        for (String s1 : split2) {
                            HealthCareMedicineDirectoryOfficial healthCareMedicineDirectoryOfficial = new HealthCareMedicineDirectoryOfficial();
                            healthCareMedicineDirectoryOfficial.setMedicineCode(medicineCode);
                            healthCareMedicineDirectoryOfficial.setMedicineCategoryLevel1(medicineCategoryLevel1);
                            healthCareMedicineDirectoryOfficial.setMedicineCategoryLevel2(medicineCategoryLevel2);
                            healthCareMedicineDirectoryOfficial.setMedicineCategoryLevel3(medicineCategoryLevel3);
                            healthCareMedicineDirectoryOfficial.setMedicineCategoryLevel4(medicineCategoryLevel4);
                            healthCareMedicineDirectoryOfficial.setMedicineName(s1);
                            healthCareMedicineDirectoryOfficial.setForm(form);
                            healthCareMedicineDirectoryOfficial.setHealthCareCategory(healthCareCategory);
                            healthCareMedicineDirectoryOfficial.setDirectoryType("02");
                            healthCareMedicineDirectoryOfficial.setComment(comment);
                            healthCareMedicineDirectoryOfficials.add(healthCareMedicineDirectoryOfficial);
                        }
                    } else if (!"".equals(medicineCategoryLevelString)) {
                        // 药品分类记录
                        if (!"".equals(row.getCell(1).toString())) {
                            setMedicineCategoryLevels(medicineCategoryLevels, 0, medicineCategoryLevelString);
                        }
                        if (!"".equals(row.getCell(2).toString())) {
                            setMedicineCategoryLevels(medicineCategoryLevels, 1, medicineCategoryLevelString);
                        }
                        if (!"".equals(row.getCell(3).toString())) {
                            setMedicineCategoryLevels(medicineCategoryLevels, 2, medicineCategoryLevelString);
                        }
                        if (!"".equals(row.getCell(4).toString())) {
                            setMedicineCategoryLevels(medicineCategoryLevels, 3, medicineCategoryLevelString);
                        }
                    }
                    count++;
                    System.out.println(count);
                }
            }
            return healthCareMedicineDirectoryOfficials;
        }
    }

    private static void setMedicineCategoryLevels(String[] medicineCategoryLevels, int index, String medicineCategoryLevel) {
        medicineCategoryLevels[index] = medicineCategoryLevel;
        for (int i = index + 1; i < medicineCategoryLevels.length; i++) {
            medicineCategoryLevels[i] = "";
        }
    }
}
