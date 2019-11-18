package cn.tedu.test;

import java.nio.file.Path;
import java.nio.file.Paths;



import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

public class SearchIndex {
   /**
    * 实现词项查询
    * @throws Exception 
    */
	@Test
	public void termQuary() throws Exception{
		//指定查询的索引目录d://index01
		Path path=Paths.get("d://index001");
		FSDirectory dir=FSDirectory.open(path);
		//获取输入流包装实现搜索对象
		IndexReader reader=DirectoryReader.open(dir);
		IndexSearcher search=new IndexSearcher(reader);
		//
		Term term=new Term("title","娱乐");
		Query query=new TermQuery(term);
		TopDocs search2 = search.search(query, 10);
;	}
}
