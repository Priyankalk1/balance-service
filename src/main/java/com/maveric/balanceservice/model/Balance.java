package com.maveric.balanceservice.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection="BalanceDetails")
public class Balance {

        @Id
        private String id;
        private String accountId;
        private Number amount;
        private String currency;
        //@CreationTimestamp
        private String createdAt;
        //@UpdateTimestamp
        private String updatedAt;


}

