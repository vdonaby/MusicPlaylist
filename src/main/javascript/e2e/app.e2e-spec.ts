import { MusicAppPage } from './app.po';

describe('music-app App', () => {
  let page: MusicAppPage;

  beforeEach(() => {
    page = new MusicAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
