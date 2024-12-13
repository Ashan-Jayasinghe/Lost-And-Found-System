package com.lostandfoundsystem.LAFS.entity;

import com.lostandfoundsystem.LAFS.entity.enums.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Report {
    @Id
    @Column(name = "report_id", nullable = false, length = 50)
    private long reportId;

    @Column(name = "subject", length = 255)
    private String subject;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "report_date", columnDefinition = "DATETIME")
    private Date reportDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_status" , nullable = false, length =100)
    private ReportStatus reportStatus;

    @Column(name = "resolved_date", columnDefinition = "DATETIME")
    private Date resolvedDate;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


}
