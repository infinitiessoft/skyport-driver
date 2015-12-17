package com.infinities.skyport.compute.entity.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dasein.cloud.Taggable;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class TaggableComparator implements Comparator<Taggable> {

	@Override
	public int compare(Taggable o1, Taggable o2) {
		List<String> aTags = convert(o1.getTags());
		List<String> bTags = convert(o2.getTags());
		return ComparisonChain.start().compare(aTags, bTags, Ordering.<String>natural().lexicographical().nullsLast())
				.result();
	}

	private List<String> convert(Map<String, String> tags) {
		List<String> ret = null;
		if (tags != null) {
			ret = new ArrayList<String>();
			for (Entry<String, String> entry : tags.entrySet()) {
				ret.add(entry.getKey() + ":" + entry.getValue());
			}
		}
		return ret;
	}

}
