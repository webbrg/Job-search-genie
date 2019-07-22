package io.ryanwebb.model;

import static org.junit.Assert.fail;

import java.io.StringReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.WithMember;

public class GithubJobFinderTest {
	// Avoid relying on actual github api - this will be for mocking purposes only.
	private static String withJobVacancies = "{   \"id\": \"d09c0c60-4450-4558-840c-e498101cef66\",   \"type\": \"Full Time\",   \"url\": \"https://jobs.github.com/positions/d09c0c60-4450-4558-840c-e498101cef66\",   \"created_at\": \"Thu Jul 18 18:26:54 UTC 2019\",   \"company\": \"Sub Rosa\",   \"company_url\": \"http://www.wearesubrosa.com\",   \"location\": \"New York\",   \"title\": \"Senior Machine Learning Engineer\",   \"description\": \"<p>JOB DESCRIPTION — Senior Machine Learning Engineer</p>\\n<p>Reports To: Senior Director of Product Strategy</p>\\n<p>OVERVIEW</p>\\n<p>Sub Rosa is a strategy and design practice headquartered in New York’s West Village. We create strategies and solutions that empower leaders and evolve organizations. Our work is grounded in Applied Empathy, a methodology created by Sub Rosa that brings insights and action together to drive change.</p>\\n<p>Sub Rosa’s innovation group is developing a high impact solution that will analyze millions of data points to provide a comprehensive analysis on audience behaviors. From unstructured text, images, and documents from multiple data sources, the Sub Rosa innovation team is working to deliver a solution using the full range of Machine Learning (ML) techniques including but not limited to supervised learning, computer vision, deep learning and online learning.</p>\\n<p>Sub Rosa is looking for a Machine Learning Engineer with an academic or practical background in machine learning, ideally with experience in algorithm design and selection, natural language processing (NLP), and unsupervised clustering algorithms.</p>\\n<p>Sub Rosa’s Innovation Group hosts a team of creative, tenacious, and extremely bright individuals tasked with building a one of a kind solution that pushes the boundaries of existing AI based technologies. If you’re looking for a challenge and are desirous to buck the status quo, come join our team.</p>\\n<p>RESPONSIBILITIES:</p>\\n<ul>\\n<li>You will work with the team to design, code, train, test, deploy and iterate on large scale machine learning systems</li>\\n<li>You will build delightful products and experiences for Fortune 1000 clients, while working alongside an excellent, multi-functional, collaborative team across Engineering, Product and Design</li>\\n<li>You will help craft the direction of machine learning and artificial intelligence at Sub Rosa</li>\\n</ul>\\n<p>REQUIREMENTS:</p>\\n<ul>\\n<li>BS and/or MS in Computer Science or a related technical field involving Machine Learning, or equivalent technical experience</li>\\n<li>5+ years of experience building machine learning or AI systems</li>\\n<li>Strong analytical and problem-solving skills</li>\\n<li>Strong programming skills in Python or equivalent</li>\\n<li>Experience with machine learning software packages (e.g. scikit-learn, Weka, TensorFlow, Caffe, Theano, Torch)</li>\\n<li>Experience in algorithm design, selection and verification</li>\\n<li>Experience with unsupervised clustering algorithms (e.g. agglomerative hierarchical clustering, k-means clustering, DBSCAN, autoencoders, etc.)</li>\\n<li>Preference in working in a collaborative team environment</li>\\n</ul>\\n<p>Desired Qualifications:</p>\\n<ul>\\n<li>PhD/Doctorate in Computer Science or related field with research in machine learning</li>\\n<li>Experience with natural language processing (NLP) and natural language generation (NLG), especially with unstructured text</li>\\n</ul>\\n<p>Application Process:\\nIf interested, please provide an up to date resume and link to your GitHub or equivalent account for review.</p>\\n<p>*Disclaimer\\nAll candidates that apply are requested to take a mandatory HackerRank test online and provide up to two references.</p>\\n\",   \"how_to_apply\": \"<p>Email resume to Harry at <a href=\"mailto:syed@wearesubrosa.com\">syed@wearesubrosa.com</a></p>\\n\",   \"company_logo\": null }";
	private static String withoutJobVacancies = "{}";
	private static GithubJobData jobData = null;
	ObjectMapper mapper = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		StringReader sReader = new StringReader(withJobVacancies);
		jobData = mapper.readValue(sReader, GithubJobData.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(jobData.toString());
	}

}
