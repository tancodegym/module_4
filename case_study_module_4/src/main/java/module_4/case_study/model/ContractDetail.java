package module_4.case_study.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contract", referencedColumnName = "id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attachService", referencedColumnName = "id")
    private AttachService attachService;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(Contract contract, AttachService attachService, int quantity) {
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
