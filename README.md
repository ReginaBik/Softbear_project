# Softbear_project
It is A BDD project with a use of Gherkin Language.
I have 6 scenarios from which I'm implementing the steps for my tests.

I use POM for easy access and code reusability, I use Junit for it's assertions and annotations.
In my project I keep all the HTML locators in pages class, I also use Hooks class to store @aftermethod annotation for code reusability.
There are 2 testing types in my projeect, that I mark with "@" tag : @Smoke and @Regression.
To run it I use my runner class thats can easily separate my tests by these tags.

I use PomXML for storing all the libraries and dependencies that i get from Maven Repository.
