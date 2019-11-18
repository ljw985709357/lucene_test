package cn.tedu.test;


import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

public class CreatIndex {
   @Test
   public void test() throws Exception{
	   //指定一个输出路劲
	   Path path=Paths.get("d://index01");
	   //
	   FSDirectory dir=FSDirectory.open(path);
	  //创建一个输出流配置对象
	   Analyzer analyzer=new IKAnalyzer6x();
	   IndexWriterConfig config=new IndexWriterConfig(analyzer);
	   config.setOpenMode(OpenMode.CREATE);
	   IndexWriter writer=new IndexWriter(dir, config);
	   //添加document数据
	   Document doc1=new Document();
	   Document doc2=new Document();
	   doc1.add(new TextField("title", "娱乐早知道", Store.YES));
	   doc1.add(new TextField("content", "我靠", Store.YES));
	   doc1.add(new TextField("publisher", "八卦网", Store.YES));
	   doc1.add(new StringField("web", "http://www.bagua.com/1.html", Store.YES));
	   
	   doc2.add(new TextField("title", "娱乐哈哈哈", Store.NO));
	   doc2.add(new TextField("content", "我靠，早", Store.NO));
	   doc2.add(new TextField("publisher", "娱乐网", Store.NO));
	   doc2.add(new TextField("web", "http://www.娱乐.com/1.html", Store.NO));
	   writer.addDocument(doc1);
	   writer.addDocument(doc2);
	   writer.commit();//没有数据时，创建一个有固定文件结构
   }
}
