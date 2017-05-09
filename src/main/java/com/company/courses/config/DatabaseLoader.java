package com.company.courses.config;

import com.company.courses.dao.*;
import com.company.courses.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner{

    private AchievementDao achievementDao;
    private AnswerDao answerDao;
    private ChapterDao chapterDao;
    private CourseDao courseDao;
    private DegreeDao degreeDao;
    private QuestionDao questionDao;
    private SubjectDao subjectDao;
    private EvaluationDao evaluationDao;

    @Autowired
    public DatabaseLoader(AchievementDao achievementDao, AnswerDao answerDao, ChapterDao chapterDao,
                          CourseDao courseDao, DegreeDao degreeDao, QuestionDao questionDao,
                          SubjectDao subjectDao, EvaluationDao evaluationDao){
        this.achievementDao = achievementDao;
        this.answerDao = answerDao;
        this.chapterDao = chapterDao;
        this.courseDao = courseDao;
        this.degreeDao = degreeDao;
        this.questionDao = questionDao;
        this.subjectDao = subjectDao;
        this.evaluationDao = evaluationDao;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Subject subject = new Subject();
        subject.setName("Java");
        subject.setDescription("Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented,[14] and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers \"write once, run anywhere\" (WORA),[15] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.[16] Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of computer architecture. As of 2016, Java is one of the most popular programming languages in use,[17][18][19][20] particularly for client-server web applications, with a reported 9 million developers.[21] Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle Corporation) and released in 1995 as a core component of Sun Microsystems' Java platform. The language derives much of its syntax from C and C++, but it has fewer low-level facilities than either of them.\n" +
                "\n" +
                "The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licenses. As of May 2007, in compliance with the specifications of the Java Community Process, Sun relicensed most of its Java technologies under the GNU General Public License. Others have also developed alternative implementations of these Sun technologies, such as the GNU Compiler for Java (bytecode compiler), GNU Classpath (standard libraries), and IcedTea-Web (browser plugin for applets).\n" +
                "\n" +
                "The latest version is Java 8 Update 121 which is the only version currently supported for free by Oracle, although earlier versions are supported both by Oracle and other companies on a commercial basis.");
        byte[] bytes = extractBytes("src/main/resources/static/img/java.png");
        subject.setImage(bytes);

        subjectDao.save(subject);

        subject = new Subject();
        subject.setName("Python");
        subject.setDescription("Python is a widely used high-level programming language for general-purpose programming, created by Guido van Rossum and first released in 1991. An interpreted language, Python has a design philosophy which emphasizes code readability (notably using whitespace indentation to delimit code blocks rather than curly braces or keywords), and a syntax which allows programmers to express concepts in fewer lines of code than possible in languages such as C++ or Java.[22][23] The language provides constructs intended to enable writing clear programs on both a small and large scale.[24]\n" +
                "\n" +
                "Python features a dynamic type system and automatic memory management and supports multiple programming paradigms, including object-oriented, imperative, functional programming, and procedural styles. It has a large and comprehensive standard library.[25]\n" +
                "\n" +
                "Python interpreters are available for many operating systems, allowing Python code to run on a wide variety of systems. CPython, the reference implementation of Python, is open source software[26] and has a community-based development model, as do nearly all of its variant implementations. CPython is managed by the non-profit Python Software Foundation.");
        bytes = extractBytes("src/main/resources/static/img/python.png");
        subject.setImage(bytes);

        subjectDao.save(subject);

        subject = new Subject();
        subject.setName("C#");
        subject.setDescription("C#[note 2] (pronounced as see sharp) is a multi-paradigm programming language encompassing strong typing, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines. It was developed by Microsoft within its .NET initiative and later approved as a standard by Ecma (ECMA-334) and ISO (ISO/IEC 23270:2006). C# is one of the programming languages designed for the Common Language Infrastructure.\n" +
                "\n" +
                "C# is a general-purpose, object-oriented programming language.[12] Its development team is led by Anders Hejlsberg. The most recent version is C# 7.0 which was released in 2017 along with Visual Studio 2017.");
        bytes = extractBytes("src/main/resources/static/img/csharp.jpg");
        subject.setImage(bytes);

        subjectDao.save(subject);


        subject = new Subject();
        subject.setName("PHP");
        subject.setDescription("PHP is a server-side scripting language designed primarily for web development but also used as a general-purpose programming language. Originally created by Rasmus Lerdorf in 1994,[4] the PHP reference implementation is now produced by The PHP Development Team.[5] PHP originally stood for Personal Home Page,[4] but it now stands for the recursive acronym PHP: Hypertext Preprocessor.[6]\n" +
                "\n" +
                "PHP code may be embedded into HTML or HTML5 markup, or it can be used in combination with various web template systems, web content management systems and web frameworks. PHP code is usually processed by a PHP interpreter implemented as a module in the web server or as a Common Gateway Interface (CGI) executable. The web server software combines the results of the interpreted and executed PHP code, which may be any type of data, including images, with the generated web page. PHP code may also be executed with a command-line interface (CLI) and can be used to implement standalone graphical applications.[7]\n" +
                "\n" +
                "The standard PHP interpreter, powered by the Zend Engine, is free software released under the PHP License. PHP has been widely ported and can be deployed on most web servers on almost every operating system and platform, free of charge.[8]\n" +
                "\n" +
                "The PHP language evolved without a written formal specification or standard until 2014, leaving the canonical PHP interpreter as a de facto standard. Since 2014 work has gone on to create a formal PHP specification.");
        bytes = extractBytes("src/main/resources/static/img/php.png");
        subject.setImage(bytes);

        subjectDao.save(subject);


        subject = new Subject();
        subject.setName("JavaScript");
        subject.setDescription("JavaScript, often abbreviated as \"JS\", is a high-level, dynamic, untyped, and interpreted run-time language.[7] It has been standardized in the ECMAScript language specification.[8] Alongside HTML and CSS, JavaScript is one of the three core technologies of World Wide Web content production; the majority of websites employ it, and all modern Web browsers support it without the need for plug-ins.[7] JavaScript is prototype-based with first-class functions, making it a multi-paradigm language, supporting object-oriented,[9] imperative, and functional programming styles.[7] It has an API for working with text, arrays, dates and regular expressions, but does not include any I/O, such as networking, storage, or graphics facilities, relying for these upon the host environment in which it is embedded.[8]\n" +
                "\n" +
                "Although there are strong outward similarities between JavaScript and Java, including language name, syntax, and respective standard libraries, the two are distinct languages and differ greatly in their design. JavaScript was influenced by programming languages such as Self and Scheme.[10]\n" +
                "\n" +
                "JavaScript is also used in environments that are not Web-based, such as PDF documents, site-specific browsers, and desktop widgets. Newer and faster JavaScript virtual machines (VMs) and platforms built upon them have also increased the popularity of JavaScript for server-side Web applications. On the client side, developers have traditionally implemented JavaScript as an interpreted language, but more recent browsers perform just-in-time compilation. Programmers also use JavaScript in video-game development, in crafting desktop and mobile applications, and in server-side network programming with run-time environments such as Node.js.");

        bytes = extractBytes("src/main/resources/static/img/javascript.png");


        subject.setImage(bytes);

        subjectDao.save(subject);


        subject = new Subject();
        subject.setName("Ruby");
        subject.setDescription("Ruby is a dynamic, reflective, object-oriented, general-purpose programming language. It was designed and developed in the mid-1990s by Yukihiro \"Matz\" Matsumoto in Japan.\n" +
                "\n" +
                "According to its creator, Ruby was influenced by Perl, Smalltalk, Eiffel, Ada, and Lisp.[11] It supports multiple programming paradigms, including functional, object-oriented, and imperative. It also has a dynamic type system and automatic memory management.");

        bytes = extractBytes("src/main/resources/static/img/ruby.png");
        subject.setImage(bytes);

        subjectDao.save(subject);


        subject = new Subject();
        subject.setName("Swift");
        subject.setDescription("Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. for iOS, macOS, watchOS, tvOS, and Linux. Swift is designed to work with Apple's Cocoa and Cocoa Touch frameworks and the large body of extant Objective-C (ObjC) code written for Apple products. It is built with the open source LLVM compiler framework and has been included in Xcode since version 6. On platforms other than Linux,[9] it uses the Objective-C runtime library which allows C, Objective-C, C++ and Swift code to run within one program.[10]\n" +
                "\n" +
                "Swift is intended to be more resilient to erroneous code (\"safer\") than Objective-C, and more concise. However it supports many core concepts that are associated with Objective-C; notably dynamic dispatch, widespread late binding, extensible programming and similar features. For safety, Swift helps address common programming errors like null pointers, and provides syntactic sugar to avoid the pyramid of doom that can otherwise result. More fundamentally, Swift adds the concept of protocol extensibility, an extensibility system that can be applied to types, structs and classes. Apple promotes this as a real change in programming paradigms they term \"protocol-oriented programming\".[11]\n" +
                "\n" +
                "Swift was introduced at Apple's 2014 Worldwide Developers Conference (WWDC).[12] It underwent an upgrade to version 1.2 during 2014 and a more major upgrade to Swift 2 at WWDC 2015. Initially a proprietary language, version 2.2 was made open-source software under the Apache License 2.0 on December 3, 2015, for Apple's platforms and Linux.[13][14]\n" +
                "\n" +
                "In March 2017, less than three years after its official debut, Swift made the top 10 in the monthly TIOBE index ranking of popular programming languages.");

        bytes = extractBytes("src/main/resources/static/img/swift.png");
        subject.setImage(bytes);

        subjectDao.save(subject);


        subject = new Subject();
        subject.setName("Object oriented programming");
        subject.setDescription("Object-oriented programming (OOP) is a programming paradigm based on the concept of \"objects\", which may contain data, in the form of fields, often known as attributes; and code, in the form of procedures, often known as methods. A feature of objects is that an object's procedures can access and often modify the data fields of the object with which they are associated (objects have a notion of \"this\" or \"self\"). In OOP, computer programs are designed by making them out of objects that interact with one another.[1][2] There is significant diversity of OOP languages, but the most popular ones are class-based, meaning that objects are instances of classes, which typically also determine their type.\n" +
                "\n" +
                "Many of the most widely used programming languages (such as C++, Delphi, Java, Python etc.) are multi-paradigm programming languages that support object-oriented programming to a greater or lesser degree, typically in combination with imperative, procedural programming. Significant object-oriented languages include Java, C++, C#, Python, PHP, Ruby, Perl, Object Pascal, Objective-C, Dart, Swift, Scala, Common Lisp, and Smalltalk.");

        bytes = extractBytes("src/main/resources/static/img/OOP.png");
        subject.setImage(bytes);

//        subjectDao.save(subject);



///////////////////////////////////////////////


        Course course1 = new Course();
        course1.setName("Inheritance");
        course1.setDescription("Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another. With the use of inheritance the information is made manageable in a hierarchical order.\n" +
                "\n" +
                "The class which inherits the properties of other is known as subclass (derived class, child class) and the class whose properties are inherited is known as superclass (base class, parent class).");
        bytes = extractBytes("src/main/resources/static/img/inheritance.jpg");
        course1.setImage(bytes);
        course1.setDifficulty("easy");

        subject.addCourse(course1);
        course1.setSubject(subject);

//        subjectDao.save(subject);
//        courseDao.save(course1);

        Course course2 = new Course();
        course2.setName("Polymorphism");
        course2.setDescription("Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.\n" +
                "\n" +
                "Any Java object that can pass more than one IS-A evaluation is considered to be polymorphic. In Java, all Java objects are polymorphic since any object will pass the IS-A evaluation for their own type and for the class Object.\n" +
                "\n" +
                "It is important to know that the only possible way to access an object is through a reference variable. A reference variable can be of only one type. Once declared, the type of a reference variable cannot be changed.\n" +
                "\n" +
                "The reference variable can be reassigned to other objects provided that it is not declared final. The type of the reference variable would determine the methods that it can invoke on the object.\n" +
                "\n" +
                "A reference variable can refer to any object of its declared type or any subtype of its declared type. A reference variable can be declared as a class or interface type.");

        bytes = extractBytes("src/main/resources/static/img/polymorphism.gif");
        course2.setImage(bytes);
        course2.setDifficulty("easy");

        subject.addCourse(course2);
        course2.setSubject(subject);

//        subjectDao.save(subject);
//        courseDao.save(course2);


        Course course3 = new Course();
        course3.setName("Encapsulation");
        course3.setDescription("In programming languages, encapsulation is used to refer to one of two related but distinct notions, and sometimes to the combination[1][2] thereof:\n" +
                "\n" +
                "A language mechanism for restricting direct access to some of the object's components.[3][4]\n" +
                "A language construct that facilitates the bundling of data with the methods (or other functions) operating on that data.[5][6]\n" +
                "Some programming language researchers and academics use the first meaning alone or in combination with the second as a distinguishing feature of object-oriented programming, while some programming languages which provide lexical closures view encapsulation as a feature of the language orthogonal to object orientation.\n" +
                "\n" +
                "The second definition is motivated by the fact that in many of the OOP languages hiding of components is not automatic or can be overridden; thus, information hiding is defined as a separate notion by those who prefer the second definition.\n" +
                "\n" +
                "The features of encapsulation are supported using classes in most object-oriented programming languages, although other alternatives also exist.");
        bytes = extractBytes("src/main/resources/static/img/encapsulation.jpg");
        course3.setImage(bytes);
        course3.setDifficulty("easy");

        subject.addCourse(course3);
        course3.setSubject(subject);

//        subjectDao.save(subject);
//        courseDao.save(course3);


        Course course4 = new Course();
        course4.setName("Abstraction");
        course4.setDescription("In software engineering and computer science, abstraction is a technique for arranging complexity of computer systems. It works by establishing a level of complexity on which a person interacts with the system, suppressing the more complex details below the current level. The programmer works with an idealized interface (usually well defined) and can add additional levels of functionality that would otherwise be too complex to handle. For example, a programmer writing code that involves numerical operations may not be interested in the way numbers are represented in the underlying hardware (e.g. whether they're 16 bit or 32 bit integers), and where those details have been suppressed it can be said that they were abstracted away, leaving simply numbers with which the programmer can work. In addition, a task of sending an email message across continents would be extremely complex if the programmer had to start with a piece of fiber optic cable and basic hardware components. By using layers of complexity that have been created to abstract away the physical cables and network layout, and presenting the programmer with a virtual data channel, this task is manageable.");
        bytes = extractBytes("src/main/resources/static/img/abstraction.gif");
        course4.setImage(bytes);
        course4.setDifficulty("easy");

        subject.addCourse(course4);
        course4.setSubject(subject);

//        subjectDao.save(subject);
//        courseDao.save(course4);


        Course course5 = new Course();
        course5.setName("Class");
        course5.setDescription("In object-oriented programming, a class is an extensible program-code-template for creating objects, providing initial values for state (member variables) and implementations of behavior (member functions or methods).[1][2] In many languages, the class name is used as the name for the class (the template itself), the name for the default constructor of the class (a subroutine that creates objects), and as the type of objects generated by instantiating the class; these distinct concepts are easily conflated.[2]\n" +
                "\n" +
                "When an object is created by a constructor of the class, the resulting object is called an instance of the class, and the member variables specific to the object are called instance variables, to contrast with the class variables shared across the class.\n" +
                "\n" +
                "In some languages, classes are only a compile-time feature (new classes cannot be declared at runtime), while in other languages classes are first-class citizens, and are generally themselves objects (typically of type Class or similar). In these languages, a class that creates classes is called a metaclass.");
        bytes = extractBytes("src/main/resources/static/img/class.png");
        course5.setImage(bytes);
        course5.setDifficulty("easy");

        subject.addCourse(course5);
        course5.setSubject(subject);

//        subjectDao.save(subject);
//        courseDao.save(course5);


        Course course6 = new Course();
        course6.setName("Object");
        course6.setDescription("In computer science, an object can be a variable, a data structure, a function, or a method, and as such, is a location in memory having a value and possibly referenced by an identifier.\n" +
                "\n" +
                "In the class-based object-oriented programming paradigm, \"object\" refers to a particular instance of a class where the object can be a combination of variables, functions, and data structures.\n" +
                "\n" +
                "In relational database management, an object can be a table or column, or an association between data and a database entity (such as relating a person's age to a specific person).");
        bytes = extractBytes("src/main/resources/static/img/object.png");
        course6.setImage(bytes);
        course6.setDifficulty("easy");

        subject.addCourse(course6);
        course6.setSubject(subject);

//        subjectDao.save(subject);
//        courseDao.save(course6);
//////////////////////////////////////////////////////////////////

        Chapter chapter = new Chapter();
        chapter.setTitle("Object-based languages");
        chapter.setContent("An important distinction in programming languages is the difference between an object-oriented language and an object-based language. A language is usually considered object-based if it includes the basic capabilities for an object: identity, properties, and attributes. A language is considered object-oriented if it is object-based and also has the capability of polymorphism and inheritance. Polymorphism refers to the ability to overload the name of a function with multiple behaviors based on which object(s) are passed to it. Conventional message passing discriminates only on the first object and considers that to be \"sending a message\" to that object. However, some OOP languages such as Flavors and the Common Lisp Object System (CLOS) enable discriminating on more than the first parameter of the function.[2] Inheritance is the ability to subclass an object class, to create a new class that is a subclass of an existing one and inherits all the data constraints and behaviors of its parents but also adds new and/or changes one or more of them.[3][4]");
        bytes = extractBytes("src/main/resources/static/img/javascript-java.jpg");
        chapter.setImage(bytes);

        course6.addChapter(chapter);
        chapter.setCourse(course6);

        chapter = new Chapter();
        chapter.setTitle("Object-oriented programming");
        chapter.setContent("Object-oriented programming is an approach to designing modular reusable software systems. The object-oriented approach is an evolution of good design practices that go back to the very beginning of computer programming. Object-orientation is simply the logical extension of older techniques such as structured programming and abstract data types. An object is an abstract data type with the addition of polymorphism and inheritance.\n" +
                "\n" +
                "Rather than structure programs as code and data, an object-oriented system integrates the two using the concept of an \"object\". An object has state (data) and behavior (code). Objects can correspond to things found in the real world. So for example, a graphics program will have objects such as circle, square, menu. An online shopping system will have objects such as shopping cart, customer, product. The shopping system will support behaviors such as place order, make payment, and offer discount. The objects are designed as class hierarchies. So for example with the shopping system there might be high level classes such as electronics product, kitchen product, and book. There may be further refinements for example under electronic products: CD Player, DVD player, etc. These classes and subclasses correspond to sets and subsets in mathematical logic.[");
        bytes = extractBytes("src/main/resources/static/img/javascript-java.jpg");
        chapter.setImage(bytes);

        course6.addChapter(chapter);
        chapter.setCourse(course6);

        chapter = new Chapter();
        chapter.setTitle("The Semantic Web");
        chapter.setContent("The Semantic Web is essentially a distributed objects framework. Two key technologies in the Semantic Web are the Web Ontology Language (OWL) and the Resource Description Framework (RDF). RDF provides the capability to define basic objects—names, properties, attributes, relations—that are accessible via the Internet. OWL adds a richer object model, based on set theory, that provides additional modeling capabilities such as multiple inheritance.\n" +
                "\n" +
                "OWL objects are not like standard large grained distributed objects accessed via an Interface Definition Language. Such an approach would not be appropriate for the Internet because the Internet is constantly evolving and standardization on one set of interfaces is difficult to achieve. OWL objects tend to be similar to the kind of objects used to define application domain models in programming languages such as Java and C++.\n" +
                "\n" +
                "However, there are important distinctions between OWL objects and traditional object-oriented programming objects. Where as traditional objects get compiled into static hierarchies usually with single inheritance, OWL objects are dynamic. An OWL object can change its structure at run time and can become an instance of new or different classes.\n" +
                "\n" +
                "Another critical difference is the way the model treats information that is currently not in the system. Programming objects and most database systems use the \"closed-world assumption\". If a fact is not known to the system that fact is assumed to be false. Semantic Web objects use the open-world assumption, a statement is only considered false if there is actual relevant information that it is false, otherwise it is assumed to be unknown, neither true nor false.\n" +
                "\n" +
                "OWL objects are actually most like objects in artificial intelligence frame languages such as KL-ONE and Loom.");
        bytes = extractBytes("src/main/resources/static/img/javascript-java.jpg");
        chapter.setImage(bytes);

        course6.addChapter(chapter);
        chapter.setCourse(course6);

/////////////////////////////////////////////////////////////////////////////////
        Evaluation evaluation1 = new Evaluation();

        evaluation1.setCourse(course1);
        course6.addEvaluation(evaluation1);

        Question question = new Question();
        question.setDescription("First Question ?");
        Answer answer1 = new Answer();
        answer1.setDescription("First Question First Answer.");
        answer1.addQuestion(question);
        evaluation1.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation1);
        Answer answer2 = new Answer();
        answer2.setDescription("First Question Second Answer");
        answer2.addQuestion(question);
        Answer answer3 = new Answer();
        answer3.setDescription("First Question Third Answer");
        answer3.addQuestion(question);
        Answer answer4 = new Answer();
        answer4.setDescription("First Question Fourth Answer");
        answer4.addQuestion(question);
        List<Answer> answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation1.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation1);


        question = new Question();
        question.setDescription("Second Question ?");
        answer1 = new Answer();
        answer1.setDescription("Second Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Second Question Second Answer");
        answer2.addQuestion(question);
        evaluation1.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation1);
        answer3 = new Answer();
        answer3.setDescription("Second Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Second Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation1.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation1);

        question = new Question();
        question.setDescription("Third Question ?");
        answer1 = new Answer();
        answer1.setDescription("Third Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Third Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Third Question Third Answer");
        answer3.addQuestion(question);
        evaluation1.addCorrectAnswer(answer3);
//        answer3.addCorrectAnswersEvaluations(evaluation);
        answer3.setEvaluation(evaluation1);
        answer4 = new Answer();
        answer4.setDescription("Third Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer3);
        answer3.addCorrectAnswerToQuestion(question);
        evaluation1.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation1);

        question = new Question();
        question.setDescription("Fourth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fourth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Fourth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fourth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fourth Question Fourth Answer");
        answer4.addQuestion(question);
        evaluation1.addCorrectAnswer(answer4);
//        answer4.addCorrectAnswersEvaluations(evaluation);
        answer4.setEvaluation(evaluation1);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer4);
        answer4.addCorrectAnswerToQuestion(question);
        evaluation1.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation1);

        question = new Question();
        question.setDescription("Fifth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fifth Question First Answer");
        answer1.addQuestion(question);
        evaluation1.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation1);
        answer2 = new Answer();
        answer2.setDescription("Fifth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fifth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fifth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation1.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation1);

        question = new Question();
        question.setDescription("Sixth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Sixth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Sixth Question Second Answer");
        answer2.addQuestion(question);
        evaluation1.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation1);
        answer3 = new Answer();
        answer3.setDescription("Sixth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Sixth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation1.addQuestion(question);
//        question.addEvaluation(evaluation);

        question.setEvaluation(evaluation1);



        Evaluation evaluation2 = new Evaluation();

        evaluation2.setCourse(course2);
        course6.addEvaluation(evaluation2);

        question = new Question();
        question.setDescription("First Question ?");
        answer1 = new Answer();
        answer1.setDescription("First Question First Answer.");
        answer1.addQuestion(question);
        evaluation2.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation2);
        answer2 = new Answer();
        answer2.setDescription("First Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("First Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("First Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation2.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation2);


        question = new Question();
        question.setDescription("Second Question ?");
        answer1 = new Answer();
        answer1.setDescription("Second Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Second Question Second Answer");
        answer2.addQuestion(question);
        evaluation2.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation2);
        answer3 = new Answer();
        answer3.setDescription("Second Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Second Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation2.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation2);

        question = new Question();
        question.setDescription("Third Question ?");
        answer1 = new Answer();
        answer1.setDescription("Third Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Third Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Third Question Third Answer");
        answer3.addQuestion(question);
        evaluation2.addCorrectAnswer(answer3);
//        answer3.addCorrectAnswersEvaluations(evaluation);
        answer3.setEvaluation(evaluation2);
        answer4 = new Answer();
        answer4.setDescription("Third Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer3);
        answer3.addCorrectAnswerToQuestion(question);
        evaluation2.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation2);

        question = new Question();
        question.setDescription("Fourth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fourth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Fourth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fourth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fourth Question Fourth Answer");
        answer4.addQuestion(question);
        evaluation2.addCorrectAnswer(answer4);
//        answer4.addCorrectAnswersEvaluations(evaluation);
        answer4.setEvaluation(evaluation2);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer4);
        answer4.addCorrectAnswerToQuestion(question);
        evaluation2.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation2);

        question = new Question();
        question.setDescription("Fifth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fifth Question First Answer");
        answer1.addQuestion(question);
        evaluation2.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation2);
        answer2 = new Answer();
        answer2.setDescription("Fifth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fifth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fifth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation2.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation2);

        question = new Question();
        question.setDescription("Sixth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Sixth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Sixth Question Second Answer");
        answer2.addQuestion(question);
        evaluation2.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation2);
        answer3 = new Answer();
        answer3.setDescription("Sixth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Sixth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation2.addQuestion(question);
//        question.addEvaluation(evaluation);

        question.setEvaluation(evaluation2);



        Evaluation evaluation3 = new Evaluation();

        evaluation3.setCourse(course3);
        course6.addEvaluation(evaluation3);

        question = new Question();
        question.setDescription("First Question ?");
        answer1 = new Answer();
        answer1.setDescription("First Question First Answer.");
        answer1.addQuestion(question);
        evaluation3.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation3);
        answer2 = new Answer();
        answer2.setDescription("First Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("First Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("First Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation3.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation3);


        question = new Question();
        question.setDescription("Second Question ?");
        answer1 = new Answer();
        answer1.setDescription("Second Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Second Question Second Answer");
        answer2.addQuestion(question);
        evaluation3.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation3);
        answer3 = new Answer();
        answer3.setDescription("Second Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Second Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation3.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation3);

        question = new Question();
        question.setDescription("Third Question ?");
        answer1 = new Answer();
        answer1.setDescription("Third Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Third Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Third Question Third Answer");
        answer3.addQuestion(question);
        evaluation3.addCorrectAnswer(answer3);
//        answer3.addCorrectAnswersEvaluations(evaluation);
        answer3.setEvaluation(evaluation3);
        answer4 = new Answer();
        answer4.setDescription("Third Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer3);
        answer3.addCorrectAnswerToQuestion(question);
        evaluation3.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation3);

        question = new Question();
        question.setDescription("Fourth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fourth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Fourth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fourth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fourth Question Fourth Answer");
        answer4.addQuestion(question);
        evaluation3.addCorrectAnswer(answer4);
//        answer4.addCorrectAnswersEvaluations(evaluation);
        answer4.setEvaluation(evaluation3);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer4);
        answer4.addCorrectAnswerToQuestion(question);
        evaluation3.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation3);

        question = new Question();
        question.setDescription("Fifth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fifth Question First Answer");
        answer1.addQuestion(question);
        evaluation3.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation3);
        answer2 = new Answer();
        answer2.setDescription("Fifth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fifth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fifth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation3.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation3);

        question = new Question();
        question.setDescription("Sixth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Sixth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Sixth Question Second Answer");
        answer2.addQuestion(question);
        evaluation3.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation3);
        answer3 = new Answer();
        answer3.setDescription("Sixth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Sixth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation3.addQuestion(question);
//        question.addEvaluation(evaluation);

        question.setEvaluation(evaluation3);


        Evaluation evaluation4 = new Evaluation();

        evaluation4.setCourse(course4);
        course6.addEvaluation(evaluation4);

        question = new Question();
        question.setDescription("First Question ?");
        answer1 = new Answer();
        answer1.setDescription("First Question First Answer.");
        answer1.addQuestion(question);
        evaluation4.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation4);
        answer2 = new Answer();
        answer2.setDescription("First Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("First Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("First Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation4.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation4);


        question = new Question();
        question.setDescription("Second Question ?");
        answer1 = new Answer();
        answer1.setDescription("Second Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Second Question Second Answer");
        answer2.addQuestion(question);
        evaluation4.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation4);
        answer3 = new Answer();
        answer3.setDescription("Second Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Second Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation4.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation4);

        question = new Question();
        question.setDescription("Third Question ?");
        answer1 = new Answer();
        answer1.setDescription("Third Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Third Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Third Question Third Answer");
        answer3.addQuestion(question);
        evaluation4.addCorrectAnswer(answer3);
//        answer3.addCorrectAnswersEvaluations(evaluation);
        answer3.setEvaluation(evaluation4);
        answer4 = new Answer();
        answer4.setDescription("Third Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer3);
        answer3.addCorrectAnswerToQuestion(question);
        evaluation4.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation4);

        question = new Question();
        question.setDescription("Fourth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fourth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Fourth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fourth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fourth Question Fourth Answer");
        answer4.addQuestion(question);
        evaluation4.addCorrectAnswer(answer4);
//        answer4.addCorrectAnswersEvaluations(evaluation);
        answer4.setEvaluation(evaluation4);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer4);
        answer4.addCorrectAnswerToQuestion(question);
        evaluation4.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation4);

        question = new Question();
        question.setDescription("Fifth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fifth Question First Answer");
        answer1.addQuestion(question);
        evaluation4.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation4);
        answer2 = new Answer();
        answer2.setDescription("Fifth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fifth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fifth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation4.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation4);

        question = new Question();
        question.setDescription("Sixth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Sixth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Sixth Question Second Answer");
        answer2.addQuestion(question);
        evaluation4.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation4);
        answer3 = new Answer();
        answer3.setDescription("Sixth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Sixth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation4.addQuestion(question);
//        question.addEvaluation(evaluation);

        question.setEvaluation(evaluation4);



        Evaluation evaluation5 = new Evaluation();

        evaluation5.setCourse(course5);
        course6.addEvaluation(evaluation5);

        question = new Question();
        question.setDescription("First Question ?");
        answer1 = new Answer();
        answer1.setDescription("First Question First Answer.");
        answer1.addQuestion(question);
        evaluation5.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation5);
        answer2 = new Answer();
        answer2.setDescription("First Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("First Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("First Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation5.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation5);


        question = new Question();
        question.setDescription("Second Question ?");
        answer1 = new Answer();
        answer1.setDescription("Second Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Second Question Second Answer");
        answer2.addQuestion(question);
        evaluation5.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation5);
        answer3 = new Answer();
        answer3.setDescription("Second Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Second Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation5.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation5);

        question = new Question();
        question.setDescription("Third Question ?");
        answer1 = new Answer();
        answer1.setDescription("Third Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Third Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Third Question Third Answer");
        answer3.addQuestion(question);
        evaluation5.addCorrectAnswer(answer3);
//        answer3.addCorrectAnswersEvaluations(evaluation);
        answer3.setEvaluation(evaluation5);
        answer4 = new Answer();
        answer4.setDescription("Third Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer3);
        answer3.addCorrectAnswerToQuestion(question);
        evaluation5.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation5);

        question = new Question();
        question.setDescription("Fourth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fourth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Fourth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fourth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fourth Question Fourth Answer");
        answer4.addQuestion(question);
        evaluation5.addCorrectAnswer(answer4);
//        answer4.addCorrectAnswersEvaluations(evaluation);
        answer4.setEvaluation(evaluation5);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer4);
        answer4.addCorrectAnswerToQuestion(question);
        evaluation5.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation5);

        question = new Question();
        question.setDescription("Fifth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fifth Question First Answer");
        answer1.addQuestion(question);
        evaluation5.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation5);
        answer2 = new Answer();
        answer2.setDescription("Fifth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fifth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fifth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation5.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation5);

        question = new Question();
        question.setDescription("Sixth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Sixth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Sixth Question Second Answer");
        answer2.addQuestion(question);
        evaluation5.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation5);
        answer3 = new Answer();
        answer3.setDescription("Sixth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Sixth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation5.addQuestion(question);
//        question.addEvaluation(evaluation);

        question.setEvaluation(evaluation5);



        Evaluation evaluation6 = new Evaluation();

        evaluation6.setCourse(course6);
        course6.addEvaluation(evaluation6);

        question = new Question();
        question.setDescription("First Question ?");
        answer1 = new Answer();
        answer1.setDescription("First Question First Answer.");
        answer1.addQuestion(question);
        evaluation6.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation6);
        answer2 = new Answer();
        answer2.setDescription("First Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("First Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("First Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation6.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation6);


        question = new Question();
        question.setDescription("Second Question ?");
        answer1 = new Answer();
        answer1.setDescription("Second Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Second Question Second Answer");
        answer2.addQuestion(question);
        evaluation6.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation6);
        answer3 = new Answer();
        answer3.setDescription("Second Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Second Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation6.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation6);

        question = new Question();
        question.setDescription("Third Question ?");
        answer1 = new Answer();
        answer1.setDescription("Third Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Third Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Third Question Third Answer");
        answer3.addQuestion(question);
        evaluation6.addCorrectAnswer(answer3);
//        answer3.addCorrectAnswersEvaluations(evaluation);
        answer3.setEvaluation(evaluation6);
        answer4 = new Answer();
        answer4.setDescription("Third Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer3);
        answer3.addCorrectAnswerToQuestion(question);
        evaluation6.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation6);

        question = new Question();
        question.setDescription("Fourth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fourth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Fourth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fourth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fourth Question Fourth Answer");
        answer4.addQuestion(question);
        evaluation6.addCorrectAnswer(answer4);
//        answer4.addCorrectAnswersEvaluations(evaluation);
        answer4.setEvaluation(evaluation6);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer4);
        answer4.addCorrectAnswerToQuestion(question);
        evaluation6.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation6);

        question = new Question();
        question.setDescription("Fifth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Fifth Question First Answer");
        answer1.addQuestion(question);
        evaluation6.addCorrectAnswer(answer1);
//        answer1.addCorrectAnswersEvaluations(evaluation);
        answer1.setEvaluation(evaluation6);
        answer2 = new Answer();
        answer2.setDescription("Fifth Question Second Answer");
        answer2.addQuestion(question);
        answer3 = new Answer();
        answer3.setDescription("Fifth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Fifth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer1);
        answer1.addCorrectAnswerToQuestion(question);
        evaluation6.addQuestion(question);
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation6);

        question = new Question();
        question.setDescription("Sixth Question ?");
        answer1 = new Answer();
        answer1.setDescription("Sixth Question First Answer");
        answer1.addQuestion(question);
        answer2 = new Answer();
        answer2.setDescription("Sixth Question Second Answer");
        answer2.addQuestion(question);
        evaluation6.addCorrectAnswer(answer2);
//        answer2.addCorrectAnswersEvaluations(evaluation);
        answer2.setEvaluation(evaluation6);
        answer3 = new Answer();
        answer3.setDescription("Sixth Question Third Answer");
        answer3.addQuestion(question);
        answer4 = new Answer();
        answer4.setDescription("Sixth Question Fourth Answer");
        answer4.addQuestion(question);
        answers = Arrays.asList(answer1,answer2,answer3,answer4);
        question.setAnswers(answers);
        question.setCorrectAnswer(answer2);
        answer2.addCorrectAnswerToQuestion(question);
        evaluation6.addQuestion(question);
//        question.addEvaluation(evaluation);

        question.setEvaluation(evaluation6);

//////////////////////////////////////////////////////////////////

        Achievement achievement = new Achievement();
        achievement.setName("Inheritance apprentice");
        achievement.setDescription("By earning this badge, you started the journey of learning about inheritance.");
        achievement.setPoints(350);
        bytes = extractBytes("src/main/resources/static/img/badges/inheritance.png");
        achievement.setBadge(bytes);

        subject.addAchievement(achievement);
        achievement.setSubject(subject);

        subjectDao.save(subject);
        achievementDao.save(achievement);

        course6.setAchievement(achievement);
        achievement.setCourse(course6);

        courseDao.save(course6);

        achievement = new Achievement();
        achievement.setName("Polymorphism apprentice");
        achievement.setDescription("By earning this badge, you started the journey of learning about polymorphism.");
        achievement.setPoints(350);
        bytes = extractBytes("src/main/resources/static/img/badges/polymorphism.png");
        achievement.setBadge(bytes);

        subject.addAchievement(achievement);
        achievement.setSubject(subject);

        subjectDao.save(subject);
        achievementDao.save(achievement);

        course5.setAchievement(achievement);
        achievement.setCourse(course5);

        courseDao.save(course5);


        achievement = new Achievement();
        achievement.setName("Abstraction apprentice");
        achievement.setDescription("By earning this badge, you started the journey of learning about abstraction.");
        achievement.setPoints(350);
        bytes = extractBytes("src/main/resources/static/img/badges/abstraction.png");
        achievement.setBadge(bytes);

        subject.addAchievement(achievement);
        achievement.setSubject(subject);

        subjectDao.save(subject);
        achievementDao.save(achievement);

        course4.setAchievement(achievement);
        achievement.setCourse(course4);

        courseDao.save(course4);


        achievement = new Achievement();
        achievement.setName("Encapsulation apprentice");
        achievement.setDescription("By earning this badge, you started the journey of learning about encapsulation.");
        achievement.setPoints(350);
        bytes = extractBytes("src/main/resources/static/img/badges/encapsulation.png");
        achievement.setBadge(bytes);

        subject.addAchievement(achievement);
        achievement.setSubject(subject);

        subjectDao.save(subject);
        achievementDao.save(achievement);

        course3.setAchievement(achievement);
        achievement.setCourse(course3);

        courseDao.save(course3);

        achievement = new Achievement();
        achievement.setName("Objects apprentice");
        achievement.setDescription("By earning this badge, you started the journey of learning about objects.");
        achievement.setPoints(350);
        bytes = extractBytes("src/main/resources/static/img/badges/objects.png");
        achievement.setBadge(bytes);

        subject.addAchievement(achievement);
        achievement.setSubject(subject);

        subjectDao.save(subject);
        achievementDao.save(achievement);

        course2.setAchievement(achievement);
        achievement.setCourse(course2);

        courseDao.save(course2);

        achievement = new Achievement();
        achievement.setName("Classes apprentice");
        achievement.setDescription("By earning this badge, you started the journey of learning about classes.");
        achievement.setPoints(350);
        bytes = extractBytes("src/main/resources/static/img/badges/classes.png");
        achievement.setBadge(bytes);

        subject.addAchievement(achievement);
        achievement.setSubject(subject);

        subjectDao.save(subject);
        achievementDao.save(achievement);

        course1.setAchievement(achievement);
        achievement.setCourse(course1);

        courseDao.save(course1);

        Degree degree = new Degree();
        degree.setName("Object oriented programming master");
        degree.setDescription("This is a degree that proves your knowledge of object oriented design.");
        bytes = extractBytes("src/main/resources/static/img/degrees/oop.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);


        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

        degree = new Degree();
        degree.setName("Java Web Development");
        degree.setDescription("This is a degree in Java Web Development.");
        bytes = extractBytes("src/main/resources/static/img/degrees/certificate.png");
        degree.setDiploma(bytes);

        subject.addDegree(degree);
        degree.setSubject(subject);

        subjectDao.save(subject);
        degreeDao.save(degree);

//        subjectDao.save(subject);

    }

    private byte[] extractBytes(String ImageName) throws IOException {
        File imgPath = new File(ImageName);
        return Files.readAllBytes(imgPath.toPath());
    }
}
