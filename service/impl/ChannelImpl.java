package net.messi.early.service.impl;

import net.messi.early.mapper.NideshopChannelMapper;
import net.messi.early.pojo.NideshopChannel;
import net.messi.early.pojo.NideshopChannelExample;
import net.messi.early.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelImpl implements ChannelService {

    @Autowired
    private NideshopChannelMapper mapper;

    @Override
    public List<NideshopChannel> channelList() {

        NideshopChannelExample example = new NideshopChannelExample();
        NideshopChannelExample.Criteria criteria = example.createCriteria();

        criteria.andIconUrlIsNotNull();

        List<NideshopChannel> channels = mapper.selectByExample(example);

        return channels;
    }
}
