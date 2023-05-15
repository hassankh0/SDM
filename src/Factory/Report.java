package Factory;

import java.util.Date;

public interface Report {
    int getReportId();

    String getType();

    String getContent();

    Date getReportDate();

    void generateReport();
}
