package jobs;

import cache.ItemCache;
import models.Item;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

import java.util.List;

@OnApplicationStart(async = true)
public class Start extends Job {
	@Override
	public void doJob(){
        List<Item> allItems = Item.findAll();
        ItemCache.getInstance().updateCache(allItems);
        new ForwardCrawler().now();
	}
}
