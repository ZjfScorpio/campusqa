package cau.mickey.campusqa.service;

import cau.mickey.campusqa.constant.Constant;
import cau.mickey.campusqa.model.Question;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mickey
 * 使用solr进行搜索
 */
@Service
public class SearchService {
    private static final String SOLR_URL = "http://"+ Constant.SOLR_IP+":" + Constant.SOLR_PORT + Constant.SOLR_CORE;

    private HttpSolrClient client = new HttpSolrClient.Builder(SOLR_URL).build();

    private static final String QUESTION_TITLE = "question_title";

    private static final String QUESTION_CONTENT = "question_content";

    public boolean indexQuestion(int questionId, String title, String content) throws Exception {
        SolrInputDocument document = new SolrInputDocument();
        document.setField("id", questionId);
        document.setField(QUESTION_TITLE, title);
        document.setField(QUESTION_CONTENT, content);
        UpdateResponse response = client.add(document, 1000);
        return response != null && response.getStatus() == 0;
    }

    public List<Question> searchQuestion(String keyword, int offset, int count,
                                         String hlPre, String hlPos) throws Exception {
        List<Question> questionList = new ArrayList<>();
        //指定搜索字段
        keyword = "question_title:" + keyword + " OR question_content:"+keyword ;

        SolrQuery query = new SolrQuery(keyword);
        query.setRows(count);
        query.setStart(offset);
        query.setHighlight(true);
        query.setHighlightSimplePre(hlPre);
        query.setHighlightSimplePost(hlPos);
        query.set("hl.fl", QUESTION_TITLE + "," + QUESTION_CONTENT);
        QueryResponse response = client.query(query);
        for (Map.Entry<String, Map<String, List<String>>> entry : response.getHighlighting().entrySet()) {
            Question question = new Question();
            question.setId(Integer.parseInt(entry.getKey()));
            if (entry.getValue().containsKey(QUESTION_CONTENT)) {
                List<String> contentList = entry.getValue().get(QUESTION_CONTENT);
                if (contentList.size() > 0) {
                    question.setContent(contentList.get(0));
                }
            }
            if (entry.getValue().containsKey(QUESTION_TITLE)) {
                List<String> titleList = entry.getValue().get(QUESTION_TITLE);
                if (titleList.size() > 0) {
                    question.setTitle(titleList.get(0));
                }
            }
            questionList.add(question);
        }
        return questionList;
    }

}
