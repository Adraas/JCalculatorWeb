package ru.wkn.entities;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Cacheable(value = false)
@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;

    @Column(name = "operation_content", nullable = false)
    private String operationContent;

    @Column(name = "operation_result", nullable = false)
    private String operationResult;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, optional = false)
    @Column(name = "cookie", nullable = false, insertable = false, updatable = false)
    private String cookie;

    public Operation() {
    }

    public Operation(String operationContent, String operationResult, String cookie) {
        this.operationContent = operationContent;
        this.operationResult = operationResult;
        this.cookie = cookie;
    }

    public long getId() {
        return id;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public String getCookie() {
        return cookie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return id == operation.id &&
                Objects.equals(operationContent, operation.operationContent) &&
                Objects.equals(operationResult, operation.operationResult) &&
                Objects.equals(cookie, operation.cookie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operationContent, operationResult, cookie);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operationContent='" + operationContent + '\'' +
                ", operationResult='" + operationResult + '\'' +
                ", cookie='" + cookie + '\'' +
                '}';
    }
}
