package com.example.springbootandswagger.api;

import com.example.springbootandswagger.dto.modelsRequest.GroupRequest;
import com.example.springbootandswagger.dto.modelsResponse.GroupResponse;
import com.example.springbootandswagger.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groups")
@PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
public class GroupApi {

    private final GroupService groupService;

    @PostMapping("/create/group")
    public String createGroup(@RequestBody GroupRequest groupRequest) {
        groupService.createGroup(groupRequest);
        return "Group successfully created!";
    }

    @GetMapping("/get/all/groups")
    public List<GroupResponse> getAllGroups() {
        return groupService.findAllGroups();
    }

    @GetMapping("/get/groupBy/{id}")
    public GroupResponse getById(@PathVariable Long id) {
        return groupService.findGroupById(id);
    }

    @DeleteMapping("/delete/groupBy/{id}")
    public String deleteById(@PathVariable Long id) {
        groupService.deleteGroupById(id);
        return "Group successfully deleted!";
    }

    @PutMapping("/update/groupBy/{id}")
    public String updateById(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        groupService.updateGroup(id, groupRequest);
        return "Company successfully updated!";
    }
}