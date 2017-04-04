import { MusicappPage } from './app.po';

describe('musicapp App', () => {
  let page: MusicappPage;

  beforeEach(() => {
    page = new MusicappPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
