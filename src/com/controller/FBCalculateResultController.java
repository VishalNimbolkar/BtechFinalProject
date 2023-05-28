package com.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algorithms.FBClassifier;
import com.algorithms.MainClassification;


@WebServlet("/FBCalculateResultController")
public class FBCalculateResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FBCalculateResultController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
		
		String dd="16";
		
		String msgStemmingResult=(String)sess.getAttribute("msgStemmingResult");
		sess.setAttribute("data", dd);
		
		 PrintWriter out=response.getWriter();
			
			ArrayList<String>list=new ArrayList<String>();
			list.add(msgStemmingResult);
		FBClassifier<String, String> rnn = new MainClassification<String, String>();
		

		
		final String[] positiveText = {"love", "like", "happy", "good", "sunny", "able", "average" , "newsletter", 
				"from", "your", "favorite", "website",
				 "love","like", "happy", "good", "sunny", "able", "temperature","climate",
				 "wind","beautiful","waterfall","climbing","race","spring","morning","home","cleared","absolute", "absolutely", "absolutely", "awefully", 
					"categorically", "certainly", "complete", "completely", "crystal", 
					"deadly", "deeply", "definitely", "downright", "dramatically", "effin",
					"effing", "enthusiastically ", "entirely", "exceedingly", "freely",
					"fully", "goddamned", "highly", "honestly ", "incredibly", 
					"marvelously", "mightily", "mighty", "particularily", "perfectly", "positively",
					"precious", "preciously", "readily", "remarkably", "seriously", "sincerely",
					"strongly", "super", "superbly", "superduper", "thoroughgoing", "toppingly",
					"toppingly", "total", "totally", "utterly", "wonderfully", "wondrous", "wondrously","alot", "awesomely", "fairly", "far", "most", "much",
					"really", "so", "such", "too", "truely", "very", "well","amazing","awesome","brilliant","ecstatic","euphoric","exuberant","fabulous","fantastic",
					"fun","funnier","funny","godsend","heavenly","lifesaver","lmao","lmfao","masterpiece","masterpieces",
					"miracle","overjoyed","rapturous","rejoice","rejoiced","rejoices","rejoicing","rofl","roflcopter",
					"roflmao","rotfl","rotflmfao","rotflol","stunning","terrific","triumph","triumphant","win","winner",
					"winning","wins","wonderful","wooo","woow","wow","wowow","wowww","breathtaking","hurrah","outstanding","superb","thrilled","admire","admired","admires","admiring","adorable","adore","adored","adores","affection",
					"affectionate","amuse","amused","amusement","amusements","astound","astounded","astounding",
					"astoundingly","astounds","audacious","award","awarded","awards","beatific","beauties","beautiful",
					"beautifully","beautify","beloved","best","blessing","bliss","blissful","blockbuster","breakthrough",
					"captivated","celebrate","celebrated","celebrates","celebrating","charm","charming","cheery","classy",
					"coolstuff","dearly","delight","delighted","delighting","delights","devoted","elated","elation",
					"enrapture","enthral","enthusiastic","euphoria","excellence","excellent","excite","excited",
					"excitement","exciting","exhilarated","exhilarates","exhilarating","exultant","exultantly","faithful",
					"fan","fascinate","fascinated","fascinates","fascinating","ftw","gallant","gallantly","gallantry",
					"genial","glad","glamorous","glamourous","glee","gleeful","good","goodness","gracious","grand",
					"grateful","great","greater","greatest","haha","hahaha","hahahah","happiness","happy","heartfelt",
					"heroic","humerous","impress","impressed","impresses","impressive","inspiring","joy","joyful",
					"joyfully","joyous","jubilant","kudos","lawl","lol","lovable","love","loved","lovelies","lovely",
					"loyal","loyalty","luck","luckily","lucky","marvel","marvelous","marvels","medal","merry","mirth",
					"mirthful","mirthfully","nice","ominous","once-in-a-lifetime","paradise","perfect","perfectly",
					"pleasant","pleased","pleasure","popular","praise","praised","praises","praising","prosperous",
					"rightdirection","rigorous","rigorously","scoop","sexy","soothe","soothed","soothing","sparkle",
					"sparkles","sparkling","splendid","successful","super","vibrant","vigilant","visionary","vitality",
					"vivacious","wealth","winwin","won","woo","woohoo","worshiped","yummy"};
				//.split("\\s");
	    rnn.learn("Normal User", Arrays.asList(positiveText));

	    final String[] negativeText = {"unlike", "unable", "hate", "sad", "bad", "rainy", "not", "like", "poor",
	    		"money","credit", "$", "sign","job","hiring","skipped",
	    		"offer", "order", "hot", "nude", "click", "amateur", "pics","videos",
	    		"hardcore","teen","sex","limited","free","advertisement","mortgage","must-read","unsubscribe",
	    		"dollar","special","deposit","donation","register","lottery","guaranteed","exotic","opening","work",
	    		"dirty","bastard","bastards","bitch","bitches","cock","cocksucker","cocksuckers","cunt",
				"motherfucker","motherfucking","niggas","nigger","prick","slut","son-of-a-bitch","twat","ass","assfucking","asshole","bullshit","catastrophic","damn","damned","damnit","dick",
				"dickhead","fraud","frauds","fraudster","fraudsters","fraudulence","fraudulent","fuck","fucked",
				"fucker","fuckers","fuckface","fuckhead","fucking","fucktard","fuked","fuking","hell","jackass",
				"jackasses","piss","pissed","rape","rapist","scumbag","shit","shithead","shrew","torture","tortured",
				"tortures","torturing","whore","wtf","abhor","abhorred","abhorrent","abhors","abuse","abused","abuses","abusive",
				"acrimonious","agonise","agonised","agonises","agonising","agonize","agonized","agonizes",
				"agonizing","anger","angers","angry","anguish","anguished","apathetic","apathy","apeshit",
				"arrested","assassination","assassinations","awful","bad","badass","badly","bankrupt","bankster",
				"betray","betrayal","betrayed","betraying","betrays","bloody","boring","brainwashing","bribe",
				"catastrophe","charged","charmless","chastise","chastised","chastises","chastising","cheat",
				"cheated","cheater","cheaters","cheats","colluding","conspiracy","cover-up","crap","crime",
				"criminal","criminals","crisis","cruel","cruelty","damage","damages","dead","deceit","deceitful",
				"deceive","deceived","deceives","deceiving","deception","defect","defects","despair","despairing",
				"despairs","desperate","desperately","despondent","destroy","destroyed","destroying","destroys",
				"destruction","destructive","die","died","dipshit","dire","direful","disastrous","disgust",
				"disgusted","disgusting","distrust","distrustful","doesnotwork","douche","douchebag","dreadful",
				"dumb","dumbass","evil","fag","faggot","faggots","fake","fakes","faking","falsified","falsify",
				"fatalities","fatality","fedup","felonies","felony","fiasco","frenzy","frightening","fud","furious",
				"goddamn","greed","greenwash","greenwashing","greenwash","greenwasher","greenwashers","greenwashing",
				"guilt","guilty","hate","hated","haters","hates","hating","heartbreaking","heartbroken","horrendous",
				"horrible","horrific","horrified","humiliated","humiliation","hysteria","hysterical","hysterics",
				"idiot","idiotic","illegal","imbecile","irate","irritate","irritated","irritating","jerk","kill",
				"killed","killing","kills","liar","liars","loathe","loathed","loathes","loathing","loose","looses",
				"loser","losing","loss","lost","lunatic","lunatics","mad","maddening","madly","madness","mediocrity",
				"miserable","misleading","moron","murdering","murderous","nasty","nofun","notworking","nuts",
				"obnoxious","outrage","outraged","panic","panicked","panics","perjury","pissing","pseudoscience",
				"racism","racist","racists","rant","ranter","ranters","rants","ridiculous","scandal","scandalous",
				"scandals","screwedup","selfish","selfishness","shitty","sinful","slavery","spammer","spammers",
				"suck","sucks","swindle","swindles","swindling","terrible","terribly","terrified","terror",
				"terrorize","terrorized","terrorizes","trauma","traumatic","treason","treasonous","ugly","victim",
				"victimize","victimized","victimizes","victimizing","victims","vile","violence","violent","vitriolic",
				"wanker","warning","warnings","whitewash","withdrawal","woeful","worried","worry","worrying","worse",
				"worsen","worsened","worsening","worsens","worst","wrathful","abandon","abandoned","abandons","abducted","abduction","abductions","accident",
				"accidental","accidentally","accidents","accusation","accusations","accuse","accused","accuses",
				"accusing","ache","aching","admonish","admonished","afraid","aggravate","aggravated","aggravates",
				"aggravating","aggression","aggressions","aggressive","aghast","alarm","alarmed","alarmist","alarmists",
				"alienation","allergic","alone","animosity","annoy","annoyance","annoyed","annoying","annoys",
				"antagonistic","anxiety","anxious","apocalyptic","appalled","appalling","apprehensive","arrest",
				"arrests","arrogant","ashame","ashamed","awkward","bailout","bamboozle","bamboozled","bamboozles",
				"ban","banned","barrier","beaten","belittle","belittled","bereave","bereaved","bereaves","bereaving",
				"biased","bitter","bitterly","bizarre","blah","blame","blamed","blames","blaming","blurry","boastful",
				"bore","bored","bother","bothered","bothers","bothersome","boycott","boycotted","boycotting","boycotts",
				"brooding","bullied","bully","bullying","bummer","burden","burdened","burdening","burdens","careless",
				"cashingin","casualty","censor","censored","censors","chagrin","chagrined","chaos","chaotic","charges",
				"cheerless","childish","choke","choked","chokes","choking","clash","clueless","cocky","coerced",
				"collapse","collapsed","collapses","collapsing","collision","collisions","complacent","complain",
				"complained","complains","condemn","condemnation","condemned","condemns","conflict","conflicting",
				"conflictive","conflicts","confuse","confused","confusing","constrained","contagion","contagions",
				"contempt","contemptuous","contemptuously","contentious","contestable","controversial",
				"controversially","cornered","costly","coward","cowardly","crash","crazier","craziest","crazy",
				"crestfallen","cried","cries","critic","criticism","criticize","criticized","criticizes","criticizing",
				"critics","crushed","crying","cynic","cynical","cynicism","danger","darkest","deadlock","death",
				"debt","defeated","defenseless","deficit","degrade","degraded","degrades","dehumanize","dehumanized",
				"dehumanizes","dehumanizing","deject","dejected","dejecting","dejects","demoralized","denied","denier",
				"deniers","denies","denounce","denounces","deny","denying","depressed","depressing","derail",
				"derailed","derails","deride","derided","derides","deriding","derision","detain","detained",
				"detention","devastate","devastated","devastating","diffident","dirt","dirtier","dirtiest","dirty",
				"disadvantage","disadvantaged","disappoint","disappointed","disappointing","disappointment",
				"disappointments","disappoints","disaster","disasters","disbelieve","disconsolate","disconsolation",
				"discontented","discord","discouraged","discredited","disdain","disgrace","disgraced","disheartened",
				"dishonest","disillusioned","disinclined","disjointed","dislike","dismal","dismayed","disorder",
				"disorganized","disoriented","disparage","disparaged","disparages","disparaging","displeased",
				"dispute","disputed","disputes","disputing","disqualified","disquiet","disregard","disregarded",
				"disregarding","disregards","disrespect","disrespected","disruption","disruptions","disruptive",
				"dissatisfied","distort","distorted","distorting","distorts","distract","distracted","distraction",
				"distracts","distress","distressed","distresses","distressing","disturb","disturbed","disturbing",
				"disturbs","dithering","dodging","dodgy","dolorous","dontlike","doom","doomed","downcast",
				"downhearted","downside","drained","dread","dreaded","dreading","dreary","droopy","drown","drowned",
				"drowns","drunk","dubious","dud","dull","dumped","dupe","duped","dysfunction","eerie","eery",
				"embarrass","embarrassed","embarrasses","embarrassing","embarrassment","embittered","emergency",
				"enemies","enemy","ennui","enrage","enraged","enrages","enraging","enslave","enslaved","enslaves",
				"envious","erroneous","error","errors","exaggerate","exaggerated","exaggerates","exaggerating",
				"excluded","exhausted","expel","expelled","expelling","expels","exploit","exploited","exploiting",
				"exploits","fad","fail","failed","failing","fails","failure","failures","fainthearted","fallen",
				"fascist","fascists","fatigue","fatigued","fatigues","fatiguing","fear","fearful","fearing",
				"fearsome","feeble","fidgety","fire","fired","firing","flop","flops","flu","flustered","fool",
				"foolish","fools","foreclosure","foreclosures","forgetful","fright","frightened","frikin","frustrate",
				"frustrated","frustrates","frustrating","frustration","fuming","gag","gagged","giddy","gloomy","glum",
				"grave","greedy","grief","grieved","gross","gullibility","gullible","hapless","haplessness","hardship",
				"harm","harmed","harmful","harming","harms","harried","harsh","harsher","harshest","haunted","havoc",
				"heavyhearted","helpless","hesitant","hesitate","hindrance","hoax","homesick","hooligan","hooliganism",
				"hooligans","hopeless","hopelessness","hostile","huckster","hunger","hurt","hurting","hurts",
				"hypocritical","ignorance","ignorant","ignored","ill","illiteracy","illness","illnesses","impatient",
				"imperfect","impotent","imprisoned","inability","inaction","inadequate","incapable","incapacitated",
				"incensed","incompetence","incompetent","inconsiderate","inconvenience","inconvenient","indecisive",
				"indifference","indifferent","indignant","indignation","indoctrinate","indoctrinated","indoctrinates",
				"indoctrinating","ineffective","ineffectively","infected","inferior","inflamed","infringement",
				"infuriate","infuriated","infuriates","infuriating","injured","injury","injustice","inquisition",
				"insane","insanity","insecure","insensitive","insensitivity","insignificant","insipid","insult",
				"insulted","insulting","insults","interrogated","interrupt","interrupted","interrupting",
				"interruption","interrupts","intimidate","intimidated","intimidates","intimidating","intimidation",
				"irresolute","itchy","jailed","jealous","jeopardy","joyless","lack","lackadaisical","lagged",
				"lagging","lags","lame","lawsuit","lawsuits","lethargic","lethargy","libelous","lied","litigious",
				"livid","lobby","lobbying","lonely","lonesome","lugubrious","meaningless","melancholy","menace",
				"menaced","mess","messed","messingup","mindless","misbehave","misbehaved","misbehaves","misbehaving",
				"misery","misgiving","misinformation","misinformed","misinterpreted","misreporting",
				"misrepresentation","miss","missed","missing","mistake","mistaken","mistakes","mistaking",
				"misunderstand","misunderstanding","misunderstands","misunderstood","moan","moaned","moaning",
				"moans","mock","mocked","mocking","mocks","mongering","monopolize","monopolized","monopolizes",
				"monopolizing","mourn","mourned","mournful","mourning","mourns","mumpish","murder","murderer",
				"murders","n00b","naive","na\\xc3\\xafve","needy","negative","negativity","neglect","neglected",
				"neglecting","neglects","nervous","nervously","nonsense","noob","nosey","notgood","notorious",
				"obliterate","obliterated","obscene","obsolete","obstacle","obstacles","obstinate","odd","offend",
				"offended","offender","offending","offends","oppressed","oppressive","optionless","outcry",
				"outmaneuvered","overreact","overreacted","overreaction","overreacts","oversell","overselling",
				"oversells","oversimplification","oversimplified","oversimplifies","oversimplify","overstatement",
				"overstatements","pain","pained","pathetic","penalty","peril","perpetrator","perpetrators",
				"perplexed","persecute","persecuted","persecutes","persecuting","perturbed","pesky","pessimism",
				"pessimistic","petrified","phobic","pique","piqued","piteous","pity","poised","poison","poisoned",
				"poisons","pollute","polluted","polluter","polluters","pollutes","poor","poorer","poorest",
				"possessive","powerless","prblm","prblms","pressured","prison","prisoner","prisoners","problem",
				"problems","profiteer","propaganda","prosecuted","protest","protesters","protesting","protests",
				"punish","punished","punishes","punitive","puzzled","quaking","questionable","rage","rageful",
				"rash","rebellion","recession","reckless","refuse","refused","refusing","regret","regretful",
				"regrets","regretted","regretting","remorse","repulsed","resentful","restless","restrict",
				"restricted","restricting","restriction","restricts","retard","retarded","revenge","revengeful",
				"riot","riots","risk","risks","rob","robber","robed","robing","robs","ruin","ruined","ruining",
				"ruins","sabotage","sad","sadden","saddened","sadly","sarcastic","scam","scams","scapegoat",
				"scapegoats","scare","scared","scary","sceptical","scold","scorn","scornful","scream","screamed",
				"screaming","screams","screwed","sedition","seditious","self-deluded","sentence","sentenced",
				"sentences","sentencing","severe","shaky","shame","shamed","shameful","shattered","shock","shocked",
				"shocking","shocks","short-sighted","short-sightedness","shortage","shortages","sick","sigh",
				"singleminded","skeptic","skeptical","skepticism","skeptics","slam","slash","slashed","slashes",
				"slashing","sleeplessness","sluggish","smear","smog","snub","snubbed","snubbing","snubs","somber",
				"sorrow","sorrowful","spam","spamming","speculative","spiritless","spiteful","stab","stabbed",
				"stabs","stall","stalled","stalling","stampede","startled","starve","starved","starves","starving",
				"steal","steals","stereotype","stereotyped","stingy","stolen","strangled","stressed","stressor",
				"stressors","stricken","strikers","struggle","struggled","struggles","struggling","stubborn","stuck",
				"stunned","stupid","stupidly","subversive","suffer","suffering","suffers","suicidal","suicide",
				"suing","sulking","sulky","sullen","suspicious","swear","swearing","swears","tard","tears","tense",
				"thorny","thoughtless","threat","threaten","threatened","threatening","threatens","threats","thwart",
				"thwarted","thwarting","thwarts","timid","timorous","tired","tits","toothless","torn","totalitarian",
				"totalitarianism","tout","touted","touting","touts","tragedy","tragic","trapped","travesty",
				"trembling","tremulous","tricked","trickery","trouble","troubled","troubles","tumor","unacceptable",
				"unappreciated","unapproved","unaware","uncomfortable","unconcerned","undermine","undermined",
				"undermines","undermining","undeserving","undesirable","uneasy","unemployment","unethical","unfair",
				"unfocused","unfulfilled","unhappy","unhealthy","unimpressed","unintelligent","unjust","unlovable",
				"unloved","unmotivated","unprofessional","unresearched","unsatisfied","unsecured","unsophisticated",
				"unstable","unsupported","unwanted","unworthy","upset","upsets","upsetting","uptight","useless",
				"uselessness","vague","vexation","vexing","vicious","violate","violated","violates","violating",
				"virulent","vulnerability","vulnerable","walkout","walkouts","war","warfare","warn","warned","warns",
				"wasted","wasting","weak","weakness","weary","weep","weeping","weird","wicked","woebegone","worthless",
				"wreck","wrong","wronged","yucky","zealot","zealots"};
	    
	    rnn.learn("Stressed and Depressed User", Arrays.asList(negativeText));
	    String words="";		
		
	    
	    if(list.size()>0){
			System.out.println("list size"+list.size());
			for(int i=0;i<list.size();i++){	
				words=list.get(i);
				words=words.toLowerCase();
				words=words.replace(".","");
				words=words.replace(",","");
				words=words.replace("!","");
				//words=words.replace(":d","");
				words=words.replace(":)","");
				words=words.replace(":","");
				words=words.replace(";","");
				words=words.replace("?","");
				//words=words.replace("'","");
				words=words.replace("*","");
				words=words.replace("^","");
				words=words.replace("<3","");				
				String word[]=words.split("\\s+");
				String Result = rnn.classify(Arrays.asList(word)).getCategory();
				for(int j=0;j<word.length;j++){
					word[j]=removeDup(word[j]);
				}
				System.out.println("Result:"+Result);
				sess.setAttribute("result", Result);
				
              
               
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Feature extracted & Prediction calculated successfully...');");
				out.println("location='ClassificationFB.jsp';");
				out.println("</script>");
			}
		
	    }
			
			} 
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	public  String removeDup(String str){
		str = str + " "; // Adding a space at the end of the word
        int l=str.length(); // Finding the length of the word
		String ans="";
		char ch1,ch2;
				 
        for(int i=0; i<l-1; i++)
        {
            ch1=str.charAt(i); // Extracting the first character
            ch2=str.charAt(i+1); // Extracting the next character
 
// Adding the first extracted character to the result if the current and the next characters are different
            int count= countRun(str, ch1);
            if(count==2){
            	ans = ans + ch1;
            }else if(ch1!=ch2){            
            	ans = ans + ch1;
            }            
        }
	    return ans;
    }
	
	public static int countRun( String s, char c )
	{
	    int counter = 0;
	    for( int i = 0; i < s.length(); i++)
	    {
	      if( s.charAt(i) == c )  counter++;
	      else if(counter>0) break;
	    }
	    return counter;
	}
}
