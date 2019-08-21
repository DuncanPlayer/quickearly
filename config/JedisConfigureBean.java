package net.messi.early.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import java.util.HashSet;
import java.util.Set;

@Component
public class JedisConfigureBean {


    @Bean
    public JedisCluster jedisClusterFactory() {
        Set<HostAndPort> jedisClusterFactory = new HashSet<HostAndPort>();
        jedisClusterFactory.add(new HostAndPort("192.168.43.106", 7001));
        jedisClusterFactory.add(new HostAndPort("192.168.43.94", 7003));
        jedisClusterFactory.add(new HostAndPort("192.168.43.129", 7005));
        JedisCluster jedisCluster = new JedisCluster(jedisClusterFactory);
        return jedisCluster;
    }
}
