import * as fs from 'fs'
import * as readline from 'readline'


export class Loader {
  static load(trie, file, done){
    const rl = readline.createInterface({
      input: fs.createReadStream(file)
    });

    rl.on('line', (word) => {
      if(word.length > 2){
        try {
          trie.addWord(word);
        } catch (e) {
            console.log(`${word} not added`);
        }

      }

    });

    rl.on('close', done);
  }
}
