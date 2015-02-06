package com.comdosoft.financial.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.financial.user.domain.zhangfu.MessageReceiver;
import com.comdosoft.financial.user.domain.zhangfu.SysMessage;
import com.comdosoft.financial.user.mapper.zhangfu.MessageReceiverMapper;
import com.comdosoft.financial.user.utils.page.Page;
import com.comdosoft.financial.user.utils.page.PageRequest;

@Service
public class MessageReceiverService {
    @Resource
    private MessageReceiverMapper messageReceiverMapper;

    public Page<MessageReceiver> findAll(Integer page,Integer pageSize,Integer pid) {
        PageRequest request = new PageRequest(page, pageSize);
        int count = messageReceiverMapper.count(pid);
        List<MessageReceiver> centers = messageReceiverMapper.findAll(request,pid);
        return new Page<MessageReceiver>(request, centers, count);
    }
    
    public SysMessage findById(String id) {
        SysMessage sysMessage = messageReceiverMapper.findById(Integer.parseInt(id));
        return sysMessage;
    }
    
    public void delete(String id){
        messageReceiverMapper.delete(Integer.parseInt(id));
    }
    
    public void batchDelete(String[] ids){
        messageReceiverMapper.batchDelete(ids);
    }
    
    public void batchRead(String[] ids){
        messageReceiverMapper.batchUpdate(ids);
    }

    public void isRead(String id) {
        messageReceiverMapper.isRead(id);
    }

}