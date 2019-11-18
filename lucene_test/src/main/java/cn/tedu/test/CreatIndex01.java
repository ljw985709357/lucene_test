package cn.tedu.test;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;


/**
 * 创建一个索引
 * @author 000
 *
 */
public class CreatIndex01 {
	 //1.指定一个索引的输出位置
	//2.获取输出流对象（lucene）
	//3.封装想要输出的document数据
	//4.输出到索引文件（提交）
	@Test
	public void test() throws Exception{
		Path path = Paths.get("D://index001");
		FSDirectory open = FSDirectory.open(path);
		Analyzer analyzer=new IKAnalyzer6x();
		IndexWriterConfig config=new IndexWriterConfig(analyzer);
		config.setOpenMode(OpenMode.CREATE);
		IndexWriter indexWriter=new IndexWriter(open,config);
		Document doc1=new Document();
		Document doc2=new Document();
		
		doc1.add(new TextField("titlt","华为手机", Store.YES));
		doc1.add(new TextField("content","哈哈哈", Store.YES));
		doc2.add(new TextField("titlt","中华熊猫", Store.YES));
		doc2.add(new TextField("content","哈哈哈", Store.YES));
		
		indexWriter.addDocument(doc1); 
		indexWriter.addDocument(doc2); 
		
		indexWriter.commit();
		
		
	}
   
}
