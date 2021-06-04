package dev.mnnk.studentfee.service;

import dev.mnnk.studentfee.dto.StudentFeeDTO;
import dev.mnnk.studentfee.entity.StudentFee;
import dev.mnnk.studentfee.repository.StudentFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentFeeService {

    private final StudentFeeRepository studentFeeRepository;

    @Autowired
    public StudentFeeService(StudentFeeRepository studentFeeRepository) {
        this.studentFeeRepository = studentFeeRepository;
    }

    private static StudentFeeDTO entityToDTO(StudentFee studentFee) {
        StudentFeeDTO dto = new StudentFeeDTO();
        dto.setStudentId(studentFee.getStudentId());
        dto.setFeeName(studentFee.getFeeName());
        dto.setPeriodicity(studentFee.getPeriodicity());
        dto.setFineApplicable(studentFee.getFineApplicable());
        dto.setConcessionApplicable(studentFee.getConcessionApplicable());
        dto.setPaymentPriority(studentFee.getPaymentPriority());
        dto.setAccountHeads(studentFee.getAccountHeads());
        return dto;
    }

    private static StudentFee dtoToEntity(StudentFeeDTO studentFee) {
        StudentFee fee = new StudentFee();
        fee.setFeeName(studentFee.getFeeName());
        fee.setPeriodicity(studentFee.getPeriodicity());
        fee.setFineApplicable(studentFee.getFineApplicable());
        fee.setConcessionApplicable(studentFee.getConcessionApplicable());
        fee.setPaymentPriority(studentFee.getPaymentPriority());
        fee.setAccountHeads(studentFee.getAccountHeads());
        return fee;
    }

    public List<StudentFeeDTO> getAllStudentFeeData() {

        List<StudentFee> studentFeeList = (List<StudentFee>) studentFeeRepository.findAll();
        List<StudentFeeDTO> studentFeeDTOS = studentFeeList.stream().map(
                StudentFeeService::entityToDTO
        ).collect(Collectors.toList());

        return studentFeeDTOS;
    }

    public StudentFeeDTO addStudentFeeData(StudentFeeDTO dto) {

        StudentFee studentFee = dtoToEntity(dto);
        StudentFee save = studentFeeRepository.save(studentFee);
        return entityToDTO(save);

    }

    public Boolean deleteStudent(Integer id) {

        Optional<StudentFee> studentFee = studentFeeRepository.findByStudentId(id);
        if (studentFee.isPresent()) {
            studentFeeRepository.delete(studentFee.get());
            return true;
        }

        return false;
    }

    public StudentFeeDTO updateStudentFee(StudentFeeDTO studentFeeDTO) {

        Optional<StudentFee> studentFee = studentFeeRepository.findByStudentId(studentFeeDTO.getStudentId());
        StudentFee update = studentFee.get();
        StudentFee studentUpdateObject = dtoToEntity(studentFeeDTO);
        studentUpdateObject.setStudentId(update.getStudentId());
        StudentFee save = studentFeeRepository.save(studentUpdateObject);
        return entityToDTO(save);

    }
}
