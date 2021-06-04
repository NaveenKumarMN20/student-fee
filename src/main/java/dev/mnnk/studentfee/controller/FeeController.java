package dev.mnnk.studentfee.controller;

import dev.mnnk.studentfee.dto.StudentFeeDTO;
import dev.mnnk.studentfee.service.StudentFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeeController {

    private final StudentFeeService studentFeeService;

    @Autowired
    public FeeController(StudentFeeService studentFeeService) {
        this.studentFeeService = studentFeeService;
    }


    @GetMapping("/get_all")
    public ResponseEntity getAllStudentFee() {

        List<StudentFeeDTO> allStudentFeeData = studentFeeService.getAllStudentFeeData();

        if (allStudentFeeData.isEmpty())
            return ResponseEntity.ok("No Student Data present");
        return ResponseEntity.ok(allStudentFeeData);
    }

    @PutMapping("/add_student_fee")
    public ResponseEntity addStudentFee(@RequestBody StudentFeeDTO studentFeeDTO) {

        StudentFeeDTO DTO = studentFeeService.addStudentFeeData(studentFeeDTO);
        if(DTO == null)
            return ResponseEntity.ok("Failed to add data");
        return ResponseEntity.ok(DTO);

    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudentFee(@RequestParam Integer id) {

        if(studentFeeService.deleteStudent(id))
            return ResponseEntity.ok("Deleted Successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Deleted");

    }

    @PutMapping("/update_student_fee")
    public ResponseEntity updateStudentFee(@RequestBody StudentFeeDTO studentFeeDTO) {

        StudentFeeDTO DTO = studentFeeService.updateStudentFee(studentFeeDTO);
        if(DTO == null)
            return ResponseEntity.ok("Failed to update data");
        return ResponseEntity.ok(DTO);

    }

}
