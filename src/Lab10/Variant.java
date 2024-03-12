package Lab10;

import org.apache.spark.sql.SparkSession;

// Задание:
// 1. Выбрать любой датасет на kaggle.com.
// 2. Cделать 10 выборок данных по выбранной предметной области.
// Датасет: https://www.kaggle.com/datasets/dwdkills/russian-demography.

public class Variant {
    public static void main(String[] args) {
        var spark = SparkSession.builder().appName("Lab10").getOrCreate();
        var statistics = spark.read().format("csv").option("header", "true").load("src/Lab10/dataset.csv");
        statistics.createOrReplaceTempView("statistics");

        spark.sql("SELECT * FROM statistics");
        spark.sql("SELECT * FROM statistics WHERE region = 'Amur Oblast' AND year > 2000 AND year < 2005").show();
        spark.sql("SELECT * FROM statistics WHERE region = 'Altai Krai' AND year > 2005 AND year < 2015").show();
        spark.sql("SELECT * FROM statistics WHERE region = 'Kaliningrad Oblast'").show();
        spark.sql("SELECT AVG(birth_rate) FROM statistics WHERE year < 2000").show();
        spark.sql("SELECT AVG(death_rate) FROM statistics WHERE year < 2000").show();
        spark.sql("SELECT AVG(urbanization) FROM statistics WHERE year < 2000").show();
        spark.sql("SELECT AVG(birth_rate) FROM statistics WHERE year >= 2000").show();
        spark.sql("SELECT AVG(death_rate) FROM statistics WHERE year >= 2000").show();
        spark.sql("SELECT AVG(urbanization) FROM statistics WHERE year >= 2000").show();

        spark.stop();
    }
}
