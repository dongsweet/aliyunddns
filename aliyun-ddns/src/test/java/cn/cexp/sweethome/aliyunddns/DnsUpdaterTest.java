package cn.cexp.sweethome.aliyunddns;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import cn.cexp.sweethome.common.ConfigurationLoader;

public class DnsUpdaterTest {
	
	private ConfigurationLoader<DdnsConf> loader;
	private DdnsConf conf;

	@Before
	public void before() throws IOException {
		loader = new ConfigurationLoader<DdnsConf>(DdnsConf.class);
		loader.load("D:\\ddns.conf");
		conf = loader.getConfUnique();
	}
	
	@Test
	public void testLoad() {
		DnsUpdater updater = new DnsUpdater(conf);
		updater.load();
//		Record r = updater.getRecord();
//		System.out.println(r);
	}
	
	@Test
	public void testUpdate() {
	    DnsUpdater updater = new DnsUpdater(conf);
	    updater.load();
	    System.out.println(updater.getRecordValue());
	    updater.setRecordValue("1.2.3.4");
	    updater.doUpdate();
	    updater.load();
	    System.out.println(updater.getRecordValue());
	}
}
