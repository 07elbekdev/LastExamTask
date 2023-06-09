package com.example.springbootandswagger.service;
import com.example.springbootandswagger.dto.modelsRequest.GroupRequest;
import com.example.springbootandswagger.dto.modelsResponse.GroupResponse;
import com.example.springbootandswagger.exception.CustomRuntimeException;
import com.example.springbootandswagger.model.Group;
import com.example.springbootandswagger.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;

    public GroupResponse createGroup(GroupRequest groupRequest) {
        Group group = modelMapper.map(groupRequest, Group.class);
        group = groupRepository.save(group);
        return modelMapper.map(group, GroupResponse.class);
    }

    public GroupResponse findGroupById(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Group with id: " + id+" not found"));
        return modelMapper.map(group, GroupResponse.class);
    }

    public List<GroupResponse> findAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups.stream()
                .map(group -> modelMapper.map(group, GroupResponse.class))
                .collect(Collectors.toList());
    }

    public void deleteGroupById(Long id) {
        boolean exists = groupRepository.existsById(id);
        if (!exists) {
            throw new CustomRuntimeException("Group with id : " + id + "doesn't exist.");
        }
        groupRepository.deleteById(id);
    }

    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Group not found with id " + id));
        modelMapper.map(groupRequest, group);
        group = groupRepository.save(group);
        return modelMapper.map(group, GroupResponse.class);
    }
}