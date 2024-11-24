package controller;

import view.DictionaryGUI;
import model.Dictionary;

public class DictionaryController {
    private final DictionaryGUI gui;
    private final Dictionary dict = new Dictionary();

    public DictionaryController(DictionaryGUI gui) {
        this.gui = gui;
        initializeDictionary();
    }

    private void initializeDictionary() {
        dict.addWord("example", "a representative form or pattern");
        dict.addWord("apple", "a fruit that is typically red, green, or yellow");
        dict.addWord("banana", "a long curved fruit that grows in clusters and has soft pulpy flesh and yellow skin when ripe");
        dict.addWord("cat", "a small domesticated carnivorous mammal with soft fur, a short snout, and retractile claws");
        dict.addWord("dog", "a domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, non-retractile claws, and a barking, howling, or whining voice");
        dict.addWord("elephant", "a large herbivorous mammal noted for its long trunk, columnar legs, and ivory tusks");
        dict.addWord("fish", "a limbless cold-blooded vertebrate animal with gills and fins living wholly in water");
        dict.addWord("grape", "a berry, typically green (classified as white), purple, red, or black, growing in clusters on a grapevine, eaten as fruit, and used in making wine");
        dict.addWord("house", "a building for human habitation, especially one that is lived in by a family or small group of people");
        dict.addWord("ice", "frozen water, a brittle, transparent crystalline solid");
        dict.addWord("jacket", "an outer garment extending either to the waist or the hips, typically having sleeves and a fastening down the front");
    }

    public void search() {
        String word = gui.currentSearch();
        String definition = dict.getDefinitionByWord(word);
        gui.setDefinition(word, definition);
    }
}
