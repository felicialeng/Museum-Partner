from google.appengine.ext import db,webapp
import os
from django.utils import simplejson as json
from google.appengine.ext.webapp.template import render
from google.appengine.ext.webapp.util import run_wsgi_app

class Exhibit(db.Model):
	qrcode = db.StringProperty(required=True)
	name = db.StringProperty()
	info = db.TextProperty()
	audio_url = db.StringProperty()
	wiki_url = db.StringProperty()
	video_url = db.StringProperty()
	date = db.DateTimeProperty(auto_now=True)

class MainHandler(webapp.RequestHandler):
    def get(self):
        exhibits = []
        e = Exhibit.all()
        e.order('-date')
        for exhibit in e.fetch(limit=20):
            exhibits.append(exhibit.qrcode)
        template = {'exhibits':exhibits}
        path = os.path.join(os.path.dirname(__file__), 'static/html/index.html')
        self.response.out.write(render(path,template))

class JsonHandler(webapp.RequestHandler):
    def get(self):
        try:
            qr = self.request.get('qr')
            query = db.GqlQuery("SELECT * FROM Exhibit WHERE qrcode = '%s'"%qr)
            exhibit = query.get()
            JSON_object = json.dumps({'name':exhibit.name,'info':exhibit.info,'audio_url':exhibit.audio_url,'wiki_url':exhibit.wiki_url,'video_url':exhibit.video_url},sort_keys=False)
            self.response.out.write(JSON_object)
        except:
            pass

class ExhibitHandler(webapp.RequestHandler):
	def get(self):
		template = {}
		path = os.path.join(os.path.dirname(__file__), 'static/html/exhibit.html')
		self.response.out.write(render(path, template))

	def post(self):
		exhibit = Exhibit(qrcode=self.request.get('qrcode'))

		exhibit.name = self.request.get('name')
		exhibit.info = self.request.get('info')
		exhibit.audio_url = self.request.get('audio')
		exhibit.wiki_url = self.request.get('wiki')
		exhibit.video_url = self.request.get('video')

		exhibit.put()
		self.redirect('/exhibit')

class GalleryHandler(webapp.RequestHandler):
    def get(self):
        exhibits = []
        for exhibit in Exhibit.all():
            exhibits.append(exhibit.qrcode)
        template = {'exhibits':exhibits}
        path = os.path.join(os.path.dirname(__file__), 'static/html/gallery.html')
        self.response.out.write(render(path,template))

application = webapp.WSGIApplication([
	('/', MainHandler),
	('/exhibit',ExhibitHandler),
    ('/gallery',GalleryHandler),
    ('/json',JsonHandler)
	], debug=True)


def main():
    run_wsgi_app(application)

if __name__ == "__main__":
    main()
