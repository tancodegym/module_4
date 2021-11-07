package case_study_module4.controller;

import case_study_module4.model.AttachService;
import case_study_module4.model.Contract;
import case_study_module4.model.ContractDetail;
import case_study_module4.service.IAttachService;
import case_study_module4.service.IContractDetailService;
import case_study_module4.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    IContractDetailService iContractDetailService;
    @Autowired
    IAttachService iAttachService;
    @Autowired
    IContractService iContractService;


    @ModelAttribute("contractList")
    public Iterable<Contract> getContractList(){
        return iContractService.findAll();
    }

    @ModelAttribute("attachServices")
    public Iterable<AttachService> getList(){
        return iAttachService.findAll();
    }

    @GetMapping("")
    public String showIndex(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<ContractDetail> contractDetailList = iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetailList", contractDetailList);
        return "/contract_detail/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contractDetailCreate", new ContractDetail());
        return "/contract_detail/create";
    }

    @PostMapping("/create")
    public String saveContractDetail(@PageableDefault(value = 5) Pageable pageable, @ModelAttribute("contractDetailCreate") ContractDetail contractDetail, Model model) {
        model.addAttribute("success", "Create new contract successfully !");
        iContractDetailService.save(contractDetail);
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contract_detail/create";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contractDetailEdit", iContractDetailService.findById(id));
        return "/contract_detail/edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("contractDetailEdit") ContractDetail contractDetail, Model model) {
        iContractDetailService.update(contractDetail);
        model.addAttribute("success", "Update contract successfully !");
        return "/contract_detail/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idContractDetail") Long id, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iContractDetailService.delete(id);
        model.addAttribute("success", "Delete contract detail successfully !");
        Page<ContractDetail> contractDetailList = iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetailList", contractDetailList);
        return "/contract_detail/list";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(@RequestParam("allIdContractDetail") String allIdContractDetail, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iContractDetailService.deleteAllId(allIdContractDetail);
        model.addAttribute("success", "Delete contract detail successfully !");
        Page<ContractDetail> contractDetailList = iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetailList", contractDetailList);
        return "/contract_detail/list";
    }


}
