package com.pmease.commons.git;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Lists;

public class GitUtilsTest extends AbstractGitTest {

	@Test
	public void testReadLines() {
		String content = "中文测试中文测试中文测试中文测试\r\nsecond line";
		BlobText result = BlobText.from(content.getBytes()); 
		assertEquals(Lists.newArrayList("中文测试中文测试中文测试中文测试\r", "second line"), result.getLines());
		assertEquals(false, result.isHasEolAtEof());

		result = BlobText.from("\nhello\n\nworld\n".getBytes()); 
		assertEquals(Lists.newArrayList("", "hello", "", "world"), result.getLines());
	}
	
}